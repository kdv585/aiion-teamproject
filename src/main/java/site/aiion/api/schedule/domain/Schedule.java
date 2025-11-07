package site.aiion.api.schedule.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.aiion.api.stadium.domain.Stadium;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    private Long id;

    private String scheDate;

    private String gubun;

    private String hometeamId;

    private String awayteamId;

    private Integer homeScore;

    private Integer awayScore;

    @ManyToOne
    @JoinColumn(name = "stadium_uk", referencedColumnName = "stadiumUk")
    private Stadium stadium;
}
