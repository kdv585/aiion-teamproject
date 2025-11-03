package site.aiion.api.diary.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryEntitiy {

    @Id
    private Long diaryId; // Diary_id

    private Integer year; // Year

    private Integer month; // Month

    private Integer day; // Day

    private String weekday; // Weekday

    private String title; // Title

    private String content; // Content (length 5000)
}
