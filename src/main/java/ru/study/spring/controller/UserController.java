package ru.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.study.spring.dto.UserDto;
import ru.study.spring.service.UserService;

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

}
