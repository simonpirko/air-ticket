package by.tms.finalProject.controller;

import by.tms.finalProject.constant.Role;
import by.tms.finalProject.entity.Admin;
import by.tms.finalProject.entity.Passenger;
import by.tms.finalProject.service.AdminService;
import by.tms.finalProject.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping(path = "/reg")
public class RegistrationController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ModelAndView view(ModelAndView modelAndView){
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @GetMapping(path = "/admin")
    public ModelAndView getFormAdmin(ModelAndView modelAndView){
        modelAndView.setViewName("registrationAdmin");
        modelAndView.addObject("newAdmin", new Admin());
        return modelAndView;
    }

    @PostMapping(path = "/admin")
    public ModelAndView setFormAdmin(@Valid @ModelAttribute("newAdmin") Admin admin, BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession){
          modelAndView.setViewName("registrationAdmin");
          boolean checkLogin = adminService.findAdminByLogin(admin);
          if(bindingResult.hasErrors()){
              modelAndView.setViewName("redirect:/reg");
              return modelAndView;
          }
        if (!checkLogin){
            adminService.addAdmin(admin);
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }else{
            modelAndView.addObject("messageErrorAdmin", "Такой админ уже есть");
            return modelAndView;
        }

    }

    @GetMapping(path = "/passenger")
    public ModelAndView getFormPassenger(ModelAndView modelAndView){
        modelAndView.setViewName("registrationPassenger");
        modelAndView.addObject("newPassenger", new Passenger());
        return modelAndView;
    }

    @PostMapping(path = "/passenger")
    public ModelAndView setFormPassenger(@Valid @ModelAttribute("newPassenger") Passenger passenger, BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("registrationPassenger");
        boolean checkLogin = passengerService.findPassengerByLogin(passenger);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        if(!checkLogin){
            passengerService.addPassenger(passenger);
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }else{
            modelAndView.addObject("messageErrorPassenger", "Такой пользователь уже сущесвует");
            return modelAndView;
        }
    }

}
