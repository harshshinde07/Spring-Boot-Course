package com.apps.harsh.springbootwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@SessionAttributes("name")
public class WelcomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUserName(model));
        return "welcome";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String showWelcomePage(ModelMap model, @RequestParam String name,
//                              @RequestParam String password) {
//
//        boolean isValidUser = service.validateUser(name, password);
//
//        if (isValidUser) {
//            model.put("name", name);
//            return "welcome";
//        } else {
//            model.put("errorMessage", "Invalid Credentials!!");
//            return "login";
//        }
//    }

}
