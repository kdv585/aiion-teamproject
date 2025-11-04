package site.aiion.api.team.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntity {

    @Id
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
