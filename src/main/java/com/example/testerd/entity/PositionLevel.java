package com.example.testerd.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PositionLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionLevelId;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "question_level_id")
    private QuestionLevel questionLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
