package site.aiion.api.diary.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.diary.domain.DiaryDTO;
import site.aiion.api.diary.domain.DiaryEntitiy;

@Repository
public class DiaryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Messenger save(DiaryDTO diary) {
        DiaryEntitiy entity = toEntity(diary);
        entityManager.persist(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 저장 성공");
        return messenger;
    }

    public Messenger saveAll(List<DiaryDTO> diaryList) {
        for (DiaryDTO diary : diaryList) {
            DiaryEntitiy entity = toEntity(diary);
            entityManager.persist(entity);
        }
        entityManager.flush();

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 " + diaryList.size() + "건 저장 성공");
        return messenger;
    }

    public Messenger update(DiaryDTO diary) {
        DiaryEntitiy entity = toEntity(diary);
        entityManager.merge(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 수정 성공");
        return messenger;
    }

    public Messenger delete(DiaryDTO diaryDTO) {
        if (diaryDTO.getDiaryId() != null) {
            DiaryEntitiy entity = entityManager.find(DiaryEntitiy.class, diaryDTO.getDiaryId());
            if (entity != null) {
                entityManager.remove(entity);
            }
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 삭제 성공");
        return messenger;
    }

    public Messenger findById(DiaryDTO diaryDTO) {
        if (diaryDTO.getDiaryId() != null) {
            entityManager.find(DiaryEntitiy.class, diaryDTO.getDiaryId());
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 조회 성공");
        return messenger;
    }

    public List<DiaryDTO> findAll() {
        List<DiaryEntitiy> entities = entityManager.createQuery(
                "SELECT d FROM DiaryEntitiy d", DiaryEntitiy.class)
                .getResultList();

        List<DiaryDTO> diaryList = new ArrayList<>();
        for (DiaryEntitiy entity : entities) {
            diaryList.add(toDTO(entity));
        }
        return diaryList;
    }

    private DiaryEntitiy toEntity(DiaryDTO dto) {
        return new DiaryEntitiy(
                dto.getDiaryId(),
                dto.getYear(),
                dto.getMonth(),
                dto.getDay(),
                dto.getWeekday(),
                dto.getTitle(),
                dto.getContent());
    }

    private DiaryDTO toDTO(DiaryEntitiy entity) {
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