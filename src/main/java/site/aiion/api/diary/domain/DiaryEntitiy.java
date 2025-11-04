package site.aiion.api.diary.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diaries")
@SequenceGenerator(name = "diary_seq_gen", sequenceName = "diary_seq", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diary_seq_gen")
    private Long diaryId; // Diary_id

    private Integer year; // Year

    private Integer month; // Month

    private Integer day; // Day

    private String weekday; // Weekday

    private String title; // Title

    @Column(length = 5000)
    private String content; // Content (length 5000)
}
