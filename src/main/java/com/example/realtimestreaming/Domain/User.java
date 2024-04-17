package com.example.realtimestreaming.Domain;

import com.example.realtimestreaming.Dto.Request.User.UserSignupReq;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor // @Builder 와 @NoArgsConstructor 함께 사용하는 문제 해결
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Stream> streams = new ArrayList<>();

}
