package com.example.realtimestreaming.Controller;

import com.example.realtimestreaming.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


//    @PostMapping("/signup")
//    public ResponseEntity<?> signup (@RequestBody SignupDto signupDto) {
//        User user = userService.signup(signupDto);
//        return ResponseEntity.ok(user);
//    }
}
