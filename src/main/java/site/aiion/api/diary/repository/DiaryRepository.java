package site.aiion.api.diary.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.diary.domain.DiaryDTO;
import site.aiion.api.diary.domain.Diary;

@Repository
public class DiaryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Messenger save(DiaryDTO diary) {
        Diary entity = toEntity(diary);
        entityManager.persist(entity);

        return Messenger.builder()
                .code(0)
                .message("일기 정보 저장 성공")
                .build();
    }

    public Messenger saveAll(List<DiaryDTO> diaryList) {
        for (DiaryDTO diary : diaryList) {
            Diary entity = toEntity(diary);
            entityManager.persist(entity);
        }
        entityManager.flush();

        return Messenger.builder()
                .code(0)
                .message("일기 정보 " + diaryList.size() + "건 저장 성공")
                .build();
    }

    public Messenger update(DiaryDTO diary) {
        Diary entity = toEntity(diary);
        entityManager.merge(entity);

        return Messenger.builder()
                .code(0)
                .message("일기 정보 수정 성공")
                .build();
    }

    public Messenger delete(DiaryDTO diaryDTO) {
        if (diaryDTO.getDiaryId() != null) {
            Diary entity = entityManager.find(Diary.class, diaryDTO.getDiaryId());
            if (entity != null) {
                entityManager.remove(entity);
            }
        }

        return Messenger.builder()
                .code(0)
                .message("일기 정보 삭제 성공")
                .build();
    }

    public Messenger findById(DiaryDTO diaryDTO) {
        if (diaryDTO.getDiaryId() != null) {
            entityManager.find(Diary.class, diaryDTO.getDiaryId());
        }

        return Messenger.builder()
                .code(0)
                .message("일기 정보 조회 성공")
                .build();
    }

    public List<DiaryDTO> findAll() {
        List<Diary> entities = entityManager.createQuery(
                "SELECT d FROM Diary d", Diary.class)
                .getResultList();

        List<DiaryDTO> diaryList = new ArrayList<>();
        for (Diary entity : entities) {
            diaryList.add(toDTO(entity));
        }
        return diaryList;
    }

    private Diary toEntity(DiaryDTO dto) {
        return new Diary(
                dto.getDiaryId(),
                dto.getYear(),
                dto.getMonth(),
                dto.getDay(),
                dto.getWeekday(),
                dto.getTitle(),
                dto.getContent());
    }

    private DiaryDTO toDTO(Diary entity) {
        return new DiaryDTO(
                entity.getDiaryId(),
                entity.getYear(),
                entity.getMonth(),
                entity.getDay(),
                entity.getWeekday(),
                entity.getTitle(),
                entity.getContent());
    }
}