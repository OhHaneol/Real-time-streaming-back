package com.example.realtimestreaming.Controller;

import com.example.realtimestreaming.Common.dto.ResponseDto;
import com.example.realtimestreaming.Domain.User;
import com.example.realtimestreaming.Dto.Request.User.UserSigninReq;
import com.example.realtimestreaming.Dto.Request.User.UserSignupReq;
import com.example.realtimestreaming.Dto.Response.UserSignRes;
import com.example.realtimestreaming.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto<UserSignRes>> signup(@RequestBody UserSignupReq request) {
        var user = userService.signup(request);
        return ResponseDto.created(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseDto<UserSignRes>> signin(@RequestBody UserSigninReq request) {
        var user = userService.signin(request);
        return ResponseDto.ok(user);
    }

}
