package site.aiion.api.soccer.schedule.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    
    private String scheDate;
    private String stadiumId;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private Integer homeScore;
    private Integer awayScore;
}

