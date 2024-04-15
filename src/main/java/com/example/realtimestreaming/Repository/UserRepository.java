package com.example.realtimestreaming.Repository;

import com.example.realtimestreaming.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // entity manager 대신 JPA 레포지토리로
    Boolean existsByNicknameOrEmail(String nickname, String email);

    Optional<User> findByEmail(String email);
}

