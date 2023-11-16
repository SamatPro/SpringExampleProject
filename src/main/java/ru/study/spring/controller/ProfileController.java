package ru.study.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.study.spring.dto.ProfileDto;
import ru.study.spring.model.User;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public ResponseEntity<ProfileDto> getProfile(Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        ProfileDto profileDto = ProfileDto.builder()
                .login(user.getLogin())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthday(user.getBirthday())
                .build();
        return ResponseEntity.ok(profileDto);

    }
}
