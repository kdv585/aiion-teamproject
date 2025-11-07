package site.aiion.api.healthcare.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import site.aiion.api.condition.domain.Condition;
import site.aiion.api.diary.domain.Diary;
import site.aiion.api.disease.domain.Disease;
import site.aiion.api.exercise.domain.Exercise;

@Entity
@Table(name = "healthcare")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Healthcare {

    @Id
    private Long id;

    private String exercise;
    private String disease;
    private String condition;

    @OneToMany(mappedBy = "healthcare")
    private List<Exercise> exercises;

    @OneToMany(mappedBy = "healthcare")
    private List<Disease> diseases;

    @OneToMany(mappedBy = "healthcare")
    private List<Condition> conditions;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;
}
