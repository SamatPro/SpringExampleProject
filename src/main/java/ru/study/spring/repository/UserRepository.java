package ru.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.spring.model.User;

@Repository("jparepo")
public interface UserRepository extends JpaRepository<User, Long> {

}
