package ru.study.spring.service;

import ru.study.spring.dto.LoginDto;
import ru.study.spring.dto.UserDto;
import ru.study.spring.model.User;

import javax.servlet.http.Cookie;
import java.util.Optional;

public interface UserService {
    void signUp(UserDto userDto);
    Optional<String> login(LoginDto loginDto);
    User getUserByCookie(Cookie[] cookies);
}
