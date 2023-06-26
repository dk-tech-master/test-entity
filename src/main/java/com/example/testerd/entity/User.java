package com.example.testerd.entity;

import com.example.testerd.type.UserStatus;
import com.example.testerd.type.YesNo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;

    private String password;

    private String nickname;

    private Integer loginAttempt;

    private YesNo verificationStatus;

    private UserStatus userStatus;

    private LocalDateTime passwordModifiedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Builder
    public User(String email, String password, String nickname, Integer loginAttempt, YesNo verificationStatus, UserStatus userStatus, LocalDateTime passwordModifiedAt) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.loginAttempt = loginAttempt;
        this.verificationStatus = verificationStatus;
        this.userStatus = userStatus;
        this.passwordModifiedAt = passwordModifiedAt;
    }
}
