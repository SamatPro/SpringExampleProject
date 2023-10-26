package ru.study.spring.dto;

import lombok.*;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class UserDto {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private OffsetDateTime birthday;
}
