package com.example.testerd.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationCodeId;

    private String code;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime expiredAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
