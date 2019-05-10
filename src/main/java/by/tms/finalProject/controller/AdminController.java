package by.tms.finalProject.controller;

import by.tms.finalProject.entity.*;
import by.tms.finalProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping(path = "logAdmin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "classPlace")
    public ModelAndView getFormClass(ModelAndView modelAndView){
        modelAndView.setViewName("classPlace");
        modelAndView.addObject("classPlace", new PlaceClass());
        return modelAndView;
    }

    @PostMapping(path = "classPlace")
    public ModelAndView setFormClass(@Valid @ModelAttribute("classPlace") PlaceClass placeClass, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("classPlace");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        if(adminService.findPlaceClass(placeClass) != null){
            httpServletRequest.getSession().setAttribute("errorPlaceClass", "Такой класс уже добавлен");
            modelAndView.setViewName("classPlace");
            return modelAndView;
        }
        adminService.addPlaceClass(placeClass);
        httpServletRequest.getSession().setAttribute("currentPlaceClass", placeClass);
        modelAndView.setViewName("redirect:/logAdmin/place");
        return modelAndView;
    }

    @GetMapping(path = "place")
    public ModelAndView getFormPlace(ModelAndView modelAndView){
        modelAndView.setViewName("place");
        modelAndView.addObject("newPlace", new Place());
        return modelAndView;
    }

    @PostMapping(path = "place")
    public ModelAndView setFormPlace(@Valid @ModelAttribute("newPlace") Place place, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("place");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("place");
            return modelAndView;
        }
        if(adminService.findPlace(place) != null){
            httpServletRequest.getSession().setAttribute("error", "Такое место уже введено");
            modelAndView.setViewName("place");
            return modelAndView;
        }
        PlaceClass placeClass = (PlaceClass) httpServletRequest.getSession().getAttribute("currentPlaceClass");
        place.setPlaceClass(placeClass);
        adminService.addPlace(place);
        modelAndView.setViewName("redirect:/logAdmin/place");
        return modelAndView;
    }

    @GetMapping(path = "flight")
    public ModelAndView viewFlight(ModelAndView modelAndView){
        modelAndView.setViewName("flight");
        return modelAndView;
    }

    @PostMapping(path = "flight")
    public ModelAndView setFormFlight(@RequestParam("date") Date date,@RequestParam("cityFrom") String cityFrom,@RequestParam("cityTo") String cityTo, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logAdmin/flight");
        Flight flight = new Flight();
        City _cityFrom = new City();
        City _cityTo = new City();
        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = (Date) date;
        Aircraft aircraft = (Aircraft) httpServletRequest.getSession().getAttribute("currentAircraft");
        _cityFrom.setNameCity(cityFrom);
        _cityTo.setNameCity(cityTo);

        if(date2.before(date1)){
            httpServletRequest.getSession().setAttribute("errorAddFlight", "Плохая дата");
            modelAndView.setViewName("flight");
            return modelAndView;
        }

        if(cityFrom.equals(cityTo)){
            httpServletRequest.getSession().setAttribute("errorSetCity", "Такой полет не может быть добавлен");
            modelAndView.setViewName("flight");
            return modelAndView;
        }

        if(adminService.findCity(_cityFrom) == null){
            httpServletRequest.getSession().setAttribute("findCity", "Такого города нет");
            modelAndView.setViewName("flight");
            return modelAndView;
        }
        if(adminService.findCity(_cityTo) == null){
            httpServletRequest.getSession().setAttribute("findCity1", "Такого города нет");
            modelAndView.setViewName("flight");
            return modelAndView;
        }

        flight.setFlightDate(date);
        flight.setAircraft(aircraft);
        flight.setCityFrom(adminService.findCity(_cityFrom));
        flight.setCityTo(adminService.findCity(_cityTo));
        adminService.addFlight(flight);
        httpServletRequest.getSession().setAttribute("listFlights", adminService.getAllListFlights());
        return modelAndView;
    }

    @GetMapping(path = "removeCity")
    public ModelAndView getRemoveCity(ModelAndView modelAndView){
        modelAndView.setViewName("removeCity");
        modelAndView.addObject("removeCity", new City());
        return modelAndView;
    }

    @PostMapping(path = "removeCity")
    public ModelAndView setRemoveCity(@Valid @ModelAttribute("removeCity") City city, BindingResult bindingResult, ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/logAdmin/removeCity");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        adminService.removeCity(city);
        return modelAndView;
    }

    @GetMapping(path = "removeFlight")
    public ModelAndView removeFlight(ModelAndView modelAndView){
        modelAndView.setViewName("removeFlight");
        Flight flight;
        Integer countFlight = adminService.countFlight().getId();
        for(int i = 1; i <=countFlight; i++){
            flight = adminService.findFlightById(i);
            LocalDate date2 = adminService.findFlightById(i).getFlightDate().toLocalDate();
            if(date2.isBefore(LocalDate.now())){
                adminService.deleteFlight(flight);
            }
        }
        return modelAndView;
    }

}
