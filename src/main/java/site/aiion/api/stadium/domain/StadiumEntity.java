package site.aiion.api.stadium.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stadium")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadiumEntity {

    @Id
    private String stadiumId;

    private String stadiumName;

    private String hometeamId;

    private Integer seatCount;

    private String address;

    private String ddd;

    private String tel;
}

