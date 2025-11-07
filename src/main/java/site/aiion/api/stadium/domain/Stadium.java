package site.aiion.api.stadium.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.aiion.api.schedule.domain.Schedule;
import site.aiion.api.team.domain.Team;

@Entity
@Table(name = "stadiums", uniqueConstraints = @UniqueConstraint(columnNames = "stadium_uk"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stadium {

    @Id
    private Long id;
    private String stadiumUk;
    private String stadiumName;
    private String hometeamId;
    private Integer seatCount;
    private String address;
    private String ddd;
    private String tel;

    @OneToMany(mappedBy = "stadium")
    private List<Schedule> schedules;

    @OneToOne(mappedBy = "stadium")
    private Team team;
}
