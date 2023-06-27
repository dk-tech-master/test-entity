package com.example.testerd.entity;

import com.example.testerd.type.UserStatus;
import com.example.testerd.type.YesNo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    @NotNull
    @Column(columnDefinition = "tinyint default 0")
//    @ColumnDefault("0")
    private Integer loginAttempt;

    @NotNull
    @Column(columnDefinition = "varchar(1) default 'N'")
//    @ColumnDefault("'N'")
    private YesNo verificationStatus;

    @NotNull
    @Column(columnDefinition = "varchar(255) default 'ACTIVE'")
//    @ColumnDefault("'ACTIVE'")
    private UserStatus userStatus;

    private LocalDateTime passwordModifiedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Role> roles = new ArrayList<>();

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
