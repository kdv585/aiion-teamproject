package site.aiion.api.diary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryVO {

    private Long diaryId;
    private Integer year;
    private Integer month;
    private Integer day;
    private String weekday;
    private String title;
    private String content;
}
