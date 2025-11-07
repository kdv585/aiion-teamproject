package site.aiion.api.exercise.domain;

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
@Table(name = "exercises")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    private Long id;

    private String kategori;
    private String e_name;
    private String level;

    @ManyToOne
    @JoinColumn(name = "healthcare_id")
    private Healthcare healthcare;
}
