package com.example.testerd.entity;

import com.example.testerd.type.YesNo;
import lombok.AccessLevel;
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
public class ChecklistResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checklistResultId;

    private YesNo isChecked;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    private Checklist checklist;

    @OneToOne
    @JoinColumn(name = "interview_question_id")
    private InterviewQuestion interviewQuestion;

    @ManyToOne
    @JoinColumn(name = "interview_result_id")
    private InterviewResult interviewResult;
}