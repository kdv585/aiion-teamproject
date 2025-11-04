package site.aiion.api.player.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerEntity {

    @Id
    private String playerId;

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

    private String teamId;
}
