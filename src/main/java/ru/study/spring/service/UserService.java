package ru.study.spring.service;

import ru.study.spring.dto.UserDto;

public interface UserService {
    void signUp(UserDto userDto);
}
