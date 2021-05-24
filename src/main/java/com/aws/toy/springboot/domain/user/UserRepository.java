package com.aws.toy.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
    User의 CRUD 동작할 레포지토리
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String Email);
}
