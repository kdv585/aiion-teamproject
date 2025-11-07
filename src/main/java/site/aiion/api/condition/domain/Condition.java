package site.aiion.api.condition.domain;

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
@Table(name = "conditions")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Condition {

    @Id
    private Long id;

    private String c_date;
    private String sleep_hours;
    private String energy_level;
    private String mood;

    @ManyToOne
    @JoinColumn(name = "healthcare_id")
    private Healthcare healthcare;
}
