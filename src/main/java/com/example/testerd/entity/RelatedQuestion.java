package com.example.testerd.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RelatedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relatedQuestionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_question_id")
    private Question headQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tail_question_id")
    private Question tailQuestion;
}
