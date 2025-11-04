package site.aiion.api.player.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

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
