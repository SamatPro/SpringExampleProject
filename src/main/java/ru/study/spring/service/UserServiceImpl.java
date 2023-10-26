package ru.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.study.spring.dto.UserDto;
import ru.study.spring.model.User;
import ru.study.spring.model.enums.Role;
import ru.study.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void signUp(UserDto userDto) {

        User user = User.builder()
                .login(userDto.getLogin())
                .passwordHash(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}
