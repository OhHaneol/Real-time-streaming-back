package com.example.realtimestreaming.Dto.Request.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class UserSigninReq {
    private String email;
    private String password;
}
