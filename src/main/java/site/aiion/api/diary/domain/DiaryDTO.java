package site.aiion.api.diary.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDTO {
    
    private Long diaryId;
    private Integer year;
    private Integer month;
    private Integer day;
    private String weekday;
    private String title;
    private String content;
}
