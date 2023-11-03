package ru.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.study.spring.model.Auth;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByCookieValue(String cookie);
}
