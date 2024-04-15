package com.example.realtimestreaming.Service;

import com.example.realtimestreaming.Domain.User;
import com.example.realtimestreaming.Dto.user.UserSignupReq;
import com.example.realtimestreaming.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    // @Autowired 대신 생성자 자동주입으로 변경
    private final UserRepository userRepository;

    // TODO 추후 보안 적용
    @Transactional
    public User signup(UserSignupReq request) {
        // TODO 추후 에러 이용해서 already exist 문제 해결
//        if (userRepository.existsByNicknameOrEmail(signupReq.getNickname(), signupReq.getEmail())) {
//            throw new
//        }

        var createdUser = userRepository.save(
                User.builder()
                        .nickname(request.getNickname())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .build()
        );
        return createdUser;
    }

    public Optional<User> findByEmail(String email) {
        // TODO 추후 에러 이용해서 not found 해결하고 Optional 아닌 User 반환
        return userRepository.findByEmail(email);
    }
}
