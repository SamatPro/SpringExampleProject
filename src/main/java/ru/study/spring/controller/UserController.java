package ru.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.study.spring.dto.LoginDto;
import ru.study.spring.dto.UserDto;
import ru.study.spring.model.User;
import ru.study.spring.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    public ModelAndView signUpPage(ModelAndView modelAndView) {
        modelAndView.setViewName("sign_up");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String signUp(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName
            ) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setLogin(login);
        userDto.setPassword(password);
        userService.signUp(userDto);
        return "sign_in";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/signin")
    public ModelAndView signInPage(ModelAndView modelAndView) {
        modelAndView.setViewName("sign_in");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public String signIn(
            @ModelAttribute("loginDto") LoginDto loginDto,
                HttpServletResponse httpServletResponse
    ) {

        Optional<String> cookieOptional = userService.login(loginDto);

        if (cookieOptional.isPresent()) {
            Cookie cookie = new Cookie("auth", cookieOptional.get());
            cookie.setMaxAge(60 * 60 * 24 * 30);
            httpServletResponse.addCookie(cookie);
            return "redirect:/profile";
        }
        return "redirect:/signin";
    }

}
