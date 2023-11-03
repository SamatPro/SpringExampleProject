package ru.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.study.spring.model.User;
import ru.study.spring.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ModelAndView getProfile(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");

        User user = userService.getUserByCookie(httpServletRequest.getCookies());

        modelAndView.addObject("firstName", user.getFirstName());
        modelAndView.addObject("lastName", user.getLastName());


        return modelAndView;
    }
}
