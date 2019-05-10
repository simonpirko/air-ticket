package by.tms.finalProject.controller;

import by.tms.finalProject.entity.Aircraft;
import by.tms.finalProject.entity.Company;
import by.tms.finalProject.entity.Country;
import by.tms.finalProject.entity.PlaceClass;
import by.tms.finalProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "logAdmin")
public class AdminCurrentValueController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "currentCountry")
    public ModelAndView getFormCountry(ModelAndView modelAndView){
        modelAndView.setViewName("currentCountry");
        modelAndView.addObject("currentCountry", new Country());
        return modelAndView;
    }

    @PostMapping(path = "currentCountry")
    public ModelAndView setFormCountry(@Valid @ModelAttribute("currentCountry") Country country, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("currentCountry");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("currentCountry");
            return modelAndView;
        }
        if(adminService.findCountry(country) == null){
            httpServletRequest.getSession().setAttribute("errorPickCountry", "Такой страны нет");
            return modelAndView;
        }
        httpServletRequest.getSession().setAttribute("currentCountry", adminService.findCountry(country));
        modelAndView.setViewName("redirect:/logAdmin/currentCountry");
        return modelAndView;
    }

    @GetMapping(path = "currentCompany")
    public ModelAndView getFormCompany(ModelAndView modelAndView){
        modelAndView.setViewName("currentCompany");
        modelAndView.addObject("currentCompany", new Company());
        return modelAndView;
    }

    @PostMapping(path = "currentCompany")
    public ModelAndView setFormCompany(@Valid @ModelAttribute("currentCompany") Company company, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logAdmin/aircraft");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("currentCompany");
            return modelAndView;
        }
        if(adminService.findCompany(company) == null){
            httpServletRequest.getSession().setAttribute("errorPickCompany", "Такой компании нет");
            modelAndView.setViewName("currentCompany");
            return modelAndView;
        }
        httpServletRequest.getSession().setAttribute("currentCompany", adminService.findCompany(company));
        modelAndView.setViewName("redirect:/logAdmin/currentCompany");
        return modelAndView;
    }

    @GetMapping(path = "currentPlaceClass")
    public ModelAndView getFormPlaceClass(ModelAndView modelAndView){
        modelAndView.setViewName("currentPlaceClass");
        modelAndView.addObject("currentPlaceClass", new PlaceClass());
        return modelAndView;
    }

    @PostMapping(path = "currentPlaceClass")
    public ModelAndView setFormPlaceClass(@Valid @ModelAttribute("currentPlaceClass") PlaceClass placeClass, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("currentPlaceClass");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        if(adminService.findPlaceClass(placeClass) == null){
            httpServletRequest.getSession().setAttribute("errorPlaceClass", "Такого класса-места нет");
            return modelAndView;
        }
        httpServletRequest.getSession().setAttribute("currentPlaceClass", adminService.findPlaceClass(placeClass));
        modelAndView.setViewName("redirect:/logAdmin/place");
        return modelAndView;
    }


}
