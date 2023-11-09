package ru.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.study.spring.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);

    @Query(nativeQuery = true, value = "select u.* from users u join auth a on u.id=a.user_id where a.cookie_value = :cookieValue")
    Optional<User> findUserByCookieValue(@Param("cookieValue") String cookieValue);
}
