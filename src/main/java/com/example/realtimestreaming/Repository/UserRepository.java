package com.example.realtimestreaming.Repository;

import com.example.realtimestreaming.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByNickname(String nickname);
    Boolean existsByEmail(String email);

    User findUserByUserId(Long userId);
//    Optional<User> findUserByToken(String token);
    User findUserByEmail(String email);
}
