package com.example.realtimestreaming.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignRes {
    private Long userId;
    private String nickname;
    private String token;
}
