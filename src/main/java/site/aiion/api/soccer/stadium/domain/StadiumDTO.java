package site.aiion.api.soccer.stadium.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadiumDTO {
    
    private String stadiumId;
    private String stadiumName;
    private String hometeamId;
    private Integer seatCount;
    private String address;
    private String ddd;
    private String tel;
}

