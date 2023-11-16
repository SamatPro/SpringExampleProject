package ru.study.spring.dto;

import lombok.*;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
public class ProfileDto {
    private String login;
    private String firstName;
    private String lastName;
    private OffsetDateTime birthday;
}
