package ru.study.spring.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class LoginDto {
    private String login;
    private String password;
}
