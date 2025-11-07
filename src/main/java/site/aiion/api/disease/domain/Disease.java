package site.aiion.api.disease.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import site.aiion.api.healthcare.domain.Healthcare;

@Entity
@Table(name = "diseases")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disease {

    @Id
    private Long id;
    private String medicine;
    private String d_name;
    private String d_risk;

    @ManyToOne
    @JoinColumn(name = "healthcare_id")
    private Healthcare healthcare;
}
