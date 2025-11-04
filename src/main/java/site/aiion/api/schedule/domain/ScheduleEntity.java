package site.aiion.api.schedule.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleEntity {

    @Id
    private String scheDate;

    private String stadiumId;

    private String gubun;

    private String hometeamId;

    private String awayteamId;

    private Integer homeScore;

    private Integer awayScore;
}

