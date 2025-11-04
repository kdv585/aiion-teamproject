package site.aiion.api.schedule.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.schedule.domain.ScheduleDTO;
import site.aiion.api.schedule.domain.ScheduleEntity;

@Repository
public class ScheduleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Messenger save(ScheduleDTO schedule) {
        ScheduleEntity entity = toEntity(schedule);
        entityManager.persist(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일정 정보 저장 성공");
        return messenger;
    }

    public Messenger saveAll(List<ScheduleDTO> scheduleList) {
        for (ScheduleDTO schedule : scheduleList) {
            ScheduleEntity entity = toEntity(schedule);
            entityManager.persist(entity);
        }
        entityManager.flush();

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일정 정보 " + scheduleList.size() + "건 저장 성공");
        return messenger;
    }

    public Messenger update(ScheduleDTO schedule) {
        ScheduleEntity entity = toEntity(schedule);
        entityManager.merge(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일정 정보 수정 성공");
        return messenger;
    }

    public Messenger delete(ScheduleDTO scheduleDTO) {
        if (scheduleDTO.getScheDate() != null) {
            ScheduleEntity entity = entityManager.find(ScheduleEntity.class, scheduleDTO.getScheDate());
            if (entity != null) {
                entityManager.remove(entity);
            }
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일정 정보 삭제 성공");
        return messenger;
    }

    public Messenger findById(ScheduleDTO scheduleDTO) {
        if (scheduleDTO.getScheDate() != null) {
            entityManager.find(ScheduleEntity.class, scheduleDTO.getScheDate());
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일정 정보 조회 성공");
        return messenger;
    }

    public List<ScheduleDTO> findAll() {
        List<ScheduleEntity> entities = entityManager.createQuery(
                "SELECT s FROM ScheduleEntity s", ScheduleEntity.class)
                .getResultList();

        List<ScheduleDTO> scheduleList = new ArrayList<>();
        for (ScheduleEntity entity : entities) {
            scheduleList.add(toDTO(entity));
        }
        return scheduleList;
    }

    private ScheduleEntity toEntity(ScheduleDTO dto) {
        return new ScheduleEntity(
                dto.getScheDate(),
                dto.getStadiumId(),
                dto.getGubun(),
                dto.getHometeamId(),
                dto.getAwayteamId(),
                dto.getHomeScore(),
                dto.getAwayScore());
    }

    private ScheduleDTO toDTO(ScheduleEntity entity) {
        return new ScheduleDTO(
                entity.getScheDate(),
                entity.getStadiumId(),
                entity.getGubun(),
                entity.getHometeamId(),
                entity.getAwayteamId(),
                entity.getHomeScore(),
                entity.getAwayScore());
    }
}

