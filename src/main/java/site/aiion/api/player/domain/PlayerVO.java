package site.aiion.api.player.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerVO {

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
