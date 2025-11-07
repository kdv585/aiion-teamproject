package site.aiion.api.player.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.aiion.api.team.domain.Team;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    private Long id;

    private String playerUk;

    private String playerName;

    private String ePlayerName;

    private String nickname;

    private String joinYyyy;

    private String position;

    private Integer backNo;

    private String nation;

    private java.sql.Date birthDate;

    private String solar;

    private Integer height;

    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "team_uk", referencedColumnName = "teamUk")
    private Team team;
}
