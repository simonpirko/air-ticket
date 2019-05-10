package by.tms.finalProject.controller;

import by.tms.finalProject.entity.*;
import by.tms.finalProject.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.util.Random;

@Controller
@RequestMapping(path = "/logPass")
public class PassengerSessionController {

    Random random = new Random();

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public ModelAndView view(ModelAndView modelAndView) {
        modelAndView.setViewName("indexPassenger");
        return modelAndView;
    }

    @GetMapping(path = "pa")
    public ModelAndView getForm(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
        modelAndView.setViewName("privateArea");
        modelAndView.addObject("pass", passengerService.findPassenger((Passenger) httpServletRequest.getSession().getAttribute("currentPass")));
        return modelAndView;
    }

    @PostMapping(path = "pa")
    public ModelAndView setForm(@Valid @ModelAttribute("pass") Passenger passenger, ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        modelAndView.setViewName("redirect:/logPass");
        System.out.println(passenger);
        passengerService.changePassenger(passenger);
        return modelAndView;
    }

    @GetMapping(path = "reserve")
    public ModelAndView getFormReserve(ModelAndView modelAndView){
        modelAndView.setViewName("reserve");
        return modelAndView;
    }

    @PostMapping(path = "reserve")
    public ModelAndView setFormReserve(@RequestParam("cityFrom") String cityFrom,@RequestParam("cityTo") String cityTo, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logPass/reserve");
        City cityF = new City();
        City cityT = new City();
        Reservation reservation = new Reservation();


        cityF.setNameCity(cityFrom);
        cityT.setNameCity(cityTo);

        if(passengerService.reservePlace(cityF, cityT) == null){
            httpServletRequest.getSession().setAttribute("errorReservePlace", "Такого рейса нет");
            return modelAndView;
        }

        httpServletRequest.getSession().setAttribute("currentFlight", passengerService.reservePlace(cityF, cityT));

        reservation.setFlight(passengerService.reservePlace(cityF, cityT));
        reservation.setPassenger((Passenger) httpServletRequest.getSession().getAttribute("currentPass"));
        passengerService.reserve(reservation);
        modelAndView.setViewName("redirect:/logPass");
        return modelAndView;
    }
}
