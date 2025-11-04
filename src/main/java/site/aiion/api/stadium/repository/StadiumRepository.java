package site.aiion.api.stadium.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.stadium.domain.StadiumDTO;
import site.aiion.api.stadium.domain.StadiumEntity;

@Repository
public class StadiumRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Messenger save(StadiumDTO stadium) {
        StadiumEntity entity = toEntity(stadium);
        entityManager.persist(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("경기장 정보 저장 성공");
        return messenger;
    }

    public Messenger saveAll(List<StadiumDTO> stadiumList) {
        for (StadiumDTO stadium : stadiumList) {
            StadiumEntity entity = toEntity(stadium);
            entityManager.persist(entity);
        }
        entityManager.flush();

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("경기장 정보 " + stadiumList.size() + "건 저장 성공");
        return messenger;
    }

    public Messenger update(StadiumDTO stadium) {
        StadiumEntity entity = toEntity(stadium);
        entityManager.merge(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("경기장 정보 수정 성공");
        return messenger;
    }

    public Messenger delete(StadiumDTO stadiumDTO) {
        if (stadiumDTO.getStadiumId() != null) {
            StadiumEntity entity = entityManager.find(StadiumEntity.class, stadiumDTO.getStadiumId());
            if (entity != null) {
                entityManager.remove(entity);
            }
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("경기장 정보 삭제 성공");
        return messenger;
    }

    public Messenger findById(StadiumDTO stadiumDTO) {
        if (stadiumDTO.getStadiumId() != null) {
            entityManager.find(StadiumEntity.class, stadiumDTO.getStadiumId());
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("경기장 정보 조회 성공");
        return messenger;
    }

    public List<StadiumDTO> findAll() {
        List<StadiumEntity> entities = entityManager.createQuery(
                "SELECT s FROM StadiumEntity s", StadiumEntity.class)
                .getResultList();

        List<StadiumDTO> stadiumList = new ArrayList<>();
        for (StadiumEntity entity : entities) {
            stadiumList.add(toDTO(entity));
        }
        return stadiumList;
    }

    private StadiumEntity toEntity(StadiumDTO dto) {
        return new StadiumEntity(
                dto.getStadiumId(),
                dto.getStadiumName(),
                dto.getHometeamId(),
                dto.getSeatCount(),
                dto.getAddress(),
                dto.getDdd(),
                dto.getTel());
    }

    private StadiumDTO toDTO(StadiumEntity entity) {
        return new StadiumDTO(
                entity.getStadiumId(),
                entity.getStadiumName(),
                entity.getHometeamId(),
                entity.getSeatCount(),
                entity.getAddress(),
                entity.getDdd(),
                entity.getTel());
    }
}

