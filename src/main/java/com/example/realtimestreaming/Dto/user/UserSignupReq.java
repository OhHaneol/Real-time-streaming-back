package com.example.realtimestreaming.Dto.user;

import lombok.Data;

@Data
public class UserSignupReq {
    private String email;
    private String password;
    private String nickname;
}
