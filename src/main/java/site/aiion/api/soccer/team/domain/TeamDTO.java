package site.aiion.api.soccer.team.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    private String teamId;
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
    private String stadiumId;
}
