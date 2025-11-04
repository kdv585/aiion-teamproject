package site.aiion.api.player.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.player.domain.PlayerDTO;
import site.aiion.api.player.domain.PlayerEntity;

@Repository
public class PlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Messenger save(PlayerDTO player) {
        PlayerEntity entity = toEntity(player);
        entityManager.persist(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("선수 정보 저장 성공");
        return messenger;
    }

    public Messenger saveAll(List<PlayerDTO> playerList) {
        for (PlayerDTO player : playerList) {
            PlayerEntity entity = toEntity(player);
            entityManager.persist(entity);
        }
        entityManager.flush();

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("선수 정보 " + playerList.size() + "건 저장 성공");
        return messenger;
    }

    public Messenger update(PlayerDTO player) {
        PlayerEntity entity = toEntity(player);
        entityManager.merge(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("선수 정보 수정 성공");
        return messenger;
    }

    public Messenger delete(PlayerDTO playerDTO) {
        if (playerDTO.getPlayerId() != null) {
            PlayerEntity entity = entityManager.find(PlayerEntity.class, playerDTO.getPlayerId());
            if (entity != null) {
                entityManager.remove(entity);
            }
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("선수 정보 삭제 성공");
        return messenger;
    }

    public Messenger findById(PlayerDTO playerDTO) {
        if (playerDTO.getPlayerId() != null) {
            entityManager.find(PlayerEntity.class, playerDTO.getPlayerId());
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("선수 정보 조회 성공");
        return messenger;
    }

    public List<PlayerDTO> findAll() {
        List<PlayerEntity> entities = entityManager.createQuery(
                "SELECT p FROM PlayerEntity p", PlayerEntity.class)
                .getResultList();

        List<PlayerDTO> playerList = new ArrayList<>();
        for (PlayerEntity entity : entities) {
            playerList.add(toDTO(entity));
        }
        return playerList;
    }

    private PlayerEntity toEntity(PlayerDTO dto) {
        return new PlayerEntity(
                dto.getPlayerId(),
                dto.getPlayerName(),
                dto.getEPlayerName(),
                dto.getNickname(),
                dto.getJoinYyyy(),
                dto.getPosition(),
                dto.getBackNo(),
                dto.getNation(),
                dto.getBirthDate(),
                dto.getSolar(),
                dto.getHeight(),
                dto.getWeight(),
                dto.getTeamId());
    }

    private PlayerDTO toDTO(PlayerEntity entity) {
        return new PlayerDTO(
                entity.getPlayerId(),
                entity.getPlayerName(),
                entity.getEPlayerName(),
                entity.getNickname(),
                entity.getJoinYyyy(),
                entity.getPosition(),
                entity.getBackNo(),
                entity.getNation(),
                entity.getBirthDate(),
                entity.getSolar(),
                entity.getHeight(),
                entity.getWeight(),
                entity.getTeamId());
    }
}
