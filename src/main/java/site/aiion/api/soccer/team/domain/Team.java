package site.aiion.api.soccer.team.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.aiion.api.soccer.player.domain.Player;
import site.aiion.api.soccer.stadium.domain.Stadium;

@Entity
@Table(name = "teams", uniqueConstraints = @UniqueConstraint(columnNames = "team_uk"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    private Long id;

    private String teamUk;

    private String regionName;

    private String teamName;

    private String eTeamName;

    private String origYyyy;

    private String zipCode1;

    private String zipCode2;

    private String address;

    private String ddd;

    private String tel;

    private String fax;

    private String homepage;

    private String owner;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @OneToOne
    @JoinColumn(name = "stadium_uk", referencedColumnName = "stadiumUk")
    private Stadium stadium;
}
