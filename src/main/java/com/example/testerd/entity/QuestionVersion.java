package com.example.testerd.entity;

import com.example.testerd.type.YesNo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class QuestionVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionVersionId;

    @NotNull
    private String title;

    @NotNull
    @Column(columnDefinition = "tinyint default 1")
//    @ColumnDefault("1")
    private Integer version;

    @NotNull
    @Column(columnDefinition = "varchar(1) default 'Y'")
    private YesNo isLatest;

    @CreatedDate
    private LocalDateTime createdAt;
}
