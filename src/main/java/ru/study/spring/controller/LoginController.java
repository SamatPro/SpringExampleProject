package ru.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.spring.dto.LoginDto;
import ru.study.spring.service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign_in")
    public ResponseEntity<String> signin(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto).get());
    }

}
