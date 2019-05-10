package by.tms.finalProject.controller;

import by.tms.finalProject.constant.Role;
import by.tms.finalProject.entity.Admin;
import by.tms.finalProject.entity.Passenger;
import by.tms.finalProject.service.AdminService;
import by.tms.finalProject.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/log")
public class LoginController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ModelAndView view(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(path = "/passenger")
    public ModelAndView getLog(ModelAndView modelAndView){
        modelAndView.setViewName("loginPassenger");
        modelAndView.addObject("checkPassenger", new Passenger());
        return modelAndView;
    }

    @PostMapping(path = "/passenger")
    public ModelAndView setLogPassenger(@Valid @ModelAttribute("checkPassenger") Passenger passenger, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("loginPassenger");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/log");
            return modelAndView;
        }
        if(passengerService.findPassenger(passenger) == null){
            httpServletRequest.getSession().setAttribute("errorLogin", "Такого пользователя не существует");
            modelAndView.setViewName("loginPassenger");
            return modelAndView;
        }
        httpServletRequest.getSession().setAttribute("role", Role.NEWUSER);
        httpServletRequest.getSession().setAttribute("currentPass", passengerService.findPassenger(passenger));
        modelAndView.setViewName("redirect:/logPass");
        return modelAndView;
    }

    @GetMapping(path = "/admin")
    public ModelAndView getLogAdmin(ModelAndView modelAndView){
        modelAndView.setViewName("loginAdmin");
        modelAndView.addObject("checkAdmin", new Admin());
        return modelAndView;
    }

    @PostMapping(path = "/admin")
    public ModelAndView setLogAdmin(@Valid @ModelAttribute("checkAdmin") Admin admin, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("loginAdmin");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/log");
            return modelAndView;
        }
        if(adminService.findAdmin(admin) == null){
            httpServletRequest.getSession().setAttribute("errorLogAdmin", "Такого админа нет");
            return modelAndView;
        }
        httpServletRequest.getSession().setAttribute("role", Role.ADMIN);
        httpServletRequest.getSession().setAttribute("currentAdmin", adminService.findAdmin(admin));
        modelAndView.setViewName("redirect:/logAdmin");
        return modelAndView;
    }
}
