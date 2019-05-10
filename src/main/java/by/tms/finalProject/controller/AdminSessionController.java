package by.tms.finalProject.controller;

import by.tms.finalProject.entity.Aircraft;
import by.tms.finalProject.entity.City;
import by.tms.finalProject.entity.Company;
import by.tms.finalProject.entity.Country;
import by.tms.finalProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "logAdmin")
public class AdminSessionController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ModelAndView view(ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("adminPrivateArea");
        httpServletRequest.getSession().setAttribute("listPassenger", adminService.getAllPassenger());
        return modelAndView;
    }

    @GetMapping(path = "company")
    public ModelAndView getFormCompany(ModelAndView modelAndView){
        modelAndView.setViewName("company");
        modelAndView.addObject("newCompany", new Company());
        return modelAndView;
    }

    @PostMapping(path = "company")
    public ModelAndView setFormCompany(@Valid @ModelAttribute("newCompany") Company company, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logAdmin/aircraft");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/logAdmin/company");
            return modelAndView;
        }
        if(adminService.findCompany(company) != null){
            httpServletRequest.getSession().setAttribute("error", "Такая компания уже существует");
            modelAndView.setViewName("company");
            return modelAndView;
        }
        adminService.addCompany(company);
        httpServletRequest.getSession().setAttribute("currentCompany", company);
        return modelAndView;
    }

    @GetMapping(path = "aircraft")
    public ModelAndView getFormAircraft(ModelAndView modelAndView){
        modelAndView.setViewName("aircraft");
        modelAndView.addObject("newAir", new Aircraft());
        return modelAndView;
    }

    @PostMapping(path = "aircraft")
    public ModelAndView setFormAircraft(@Valid @ModelAttribute("newAir") Aircraft aircraft, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logAdmin/flight");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/logAdmin/aircraft");
            return modelAndView;
        }
        if(httpServletRequest.getSession().getAttribute("currentCompany") == null){
            httpServletRequest.getSession().setAttribute("errorCurrentCompany", "Выберите компанию для добавления самолета");
            modelAndView.setViewName("aircraft");
            return modelAndView;
        }
        Company company = (Company) httpServletRequest.getSession().getAttribute("currentCompany");
        aircraft.setCompany(company);
        adminService.addAircraft(aircraft);
        httpServletRequest.getSession().setAttribute("currentAircraft", aircraft);
        return modelAndView;
    }

    @GetMapping(path = "city")
    public ModelAndView getFormCity(ModelAndView modelAndView){
        modelAndView.setViewName("city");
        modelAndView.addObject("newCity", new City());
        return modelAndView;
    }

    @PostMapping(path = "city")
    public ModelAndView setFormCity(@Valid @ModelAttribute("newCity") City city, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        modelAndView.setViewName("city");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        if(adminService.findCity(city) != null){
            httpServletRequest.getSession().setAttribute("error", "Такой город уже введен");
            return modelAndView;
        }
        if(httpServletRequest.getSession().getAttribute("currentCountry") == null){
            httpServletRequest.getSession().setAttribute("errorCurrentCountry", "Выберите страну для добавления города");
            return modelAndView;
        }
        Country currentCountry = (Country) httpServletRequest.getSession().getAttribute("currentCountry");
        city.setCountry(currentCountry);
        adminService.addCity(city);
        modelAndView.setViewName("redirect:/logAdmin/city");
        return modelAndView;
    }

    @GetMapping(path = "country")
    public ModelAndView getFormCountry(ModelAndView modelAndView){
        modelAndView.setViewName("country");
        modelAndView.addObject("newCountry", new Country());
        return modelAndView;
    }

    @PostMapping(path = "country")
    public ModelAndView setFormCountry(@Valid @ModelAttribute("newCountry") Country country, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("country");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        Country checkCountry = adminService.findCountry(country);
        if(checkCountry != null) {
            modelAndView.addObject("error", "Такое государство уже добавлено");
            return modelAndView;
        }
        adminService.addCountry(country);
        httpServletRequest.getSession().setAttribute("currentCountry", country);
        modelAndView.setViewName("redirect:/logAdmin/city");
        return modelAndView;
    }

}
