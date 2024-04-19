package com.example.realtimestreaming.Service;

import com.amazonaws.services.kms.model.AlreadyExistsException;
import com.example.realtimestreaming.Common.ErrorCode;
import com.example.realtimestreaming.Domain.User;
import com.example.realtimestreaming.Dto.Request.User.UserSigninReq;
import com.example.realtimestreaming.Dto.Request.User.UserSignupReq;
import com.example.realtimestreaming.Dto.Response.UserSignRes;
import com.example.realtimestreaming.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // TODO 추후 보안 적용
    @Transactional
    public UserSignRes signup(UserSignupReq request) {
        if (userRepository.existsByNickname(request.getNickname())) {
            throw new AlreadyExistsException(ErrorCode.NICKNAME_IS_DUPLICATED.getMessage());
        } else if (userRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsException(ErrorCode.EMAIL_IS_DUPLICATED.getMessage());
        }

        var createdUser = userRepository.save(
                User.builder()
                        .nickname(request.getNickname())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .token(UUID.randomUUID().toString())
                        .build()
        );

        return new UserSignRes(
                createdUser.getUserId(),
                createdUser.getNickname(),
                createdUser.getToken()
        );
    }

    // TODO 인터셉터 preHandle() 에서 token 확인
    public UserSignRes signin(UserSigninReq request) {
        var signinUser = userRepository.findUserByEmail(request.getEmail());
        if (signinUser == null) {
            throw new NotFoundException(ErrorCode.NO_MATCHING_USER_FOUND_WITH_EMAIL.getMessage());
        } else if(!signinUser.getPassword().equals(request.getPassword())) {
            throw new IllegalStateException(ErrorCode.NO_MATCHING_USER_FOUND_WITH_PASSWORD.getMessage());
        }

        return new UserSignRes(
                signinUser.getUserId(),
                signinUser.getNickname(),
                signinUser.getToken()
        );
    }

}
