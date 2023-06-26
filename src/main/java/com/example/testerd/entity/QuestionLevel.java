package com.example.testerd.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionLevelId;

    private String questionLevelName;
}