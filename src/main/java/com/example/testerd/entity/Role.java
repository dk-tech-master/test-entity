package com.example.testerd.entity;

import com.example.testerd.type.UserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private UserRole roleType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
