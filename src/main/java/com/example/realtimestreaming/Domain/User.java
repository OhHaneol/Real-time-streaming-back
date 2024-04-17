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
@Table(name = "user")
public class User {

    // TODO "there can be only one auto column and it must be defined as a key" 오류 해결
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(512)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(512)")
    private String password;

    @Column(name = "nickname", nullable = false, columnDefinition = "varchar(512)")
    private String nickname;

    @Column(name = "token", columnDefinition = "varchar(512)")
    private String token;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Stream> streams = new ArrayList<>();

}
