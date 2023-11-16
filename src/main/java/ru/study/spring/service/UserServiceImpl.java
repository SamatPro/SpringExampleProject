package ru.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.study.spring.dto.LoginDto;
import ru.study.spring.dto.UserDto;
import ru.study.spring.model.Auth;
import ru.study.spring.model.User;
import ru.study.spring.model.enums.Role;
import ru.study.spring.repository.AuthRepository;
import ru.study.spring.repository.UserRepository;
import ru.study.spring.security.provider.JwtProvider;

import javax.servlet.http.Cookie;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public void signUp(UserDto userDto) {

        User user = User.builder()
                .login(userDto.getLogin())
                .passwordHash(passwordEncoder.encode(userDto.getPassword()))
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }

    @Override
    public Optional<String> login(LoginDto loginDto) {

        Optional<User> userOptional = userRepository.findUserByLogin(loginDto.getLogin());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(loginDto.getPassword(), user.getPasswordHash())) {

                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginDto.getLogin(),
                                loginDto.getPassword()
                        )
                );

                String jwtToken = jwtProvider.generateToken(authentication);

                return Optional.of(jwtToken);
            }
        }

        throw new IllegalArgumentException("Login attempt failed");
    }

    @Override
    public User getUserByCookie(Cookie[] cookies) {

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("auth")) {
                    Optional<Auth> authOptional = authRepository.findByCookieValue(cookie.getValue());
                    if (authOptional.isPresent()) {
                        User user = authOptional.get().getUser();
                        return user;
                    }
                }
            }

        }

        return null;
    }
}
