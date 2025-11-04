package site.aiion.api.team.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.team.domain.TeamDTO;
import site.aiion.api.team.domain.TeamEntity;

@Repository
public class TeamRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Messenger save(TeamDTO team) {
        TeamEntity entity = toEntity(team);
        entityManager.persist(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("팀 정보 저장 성공");
        return messenger;
    }

    public Messenger saveAll(List<TeamDTO> teamList) {
        for (TeamDTO team : teamList) {
            TeamEntity entity = toEntity(team);
            entityManager.persist(entity);
        }
        entityManager.flush();

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("팀 정보 " + teamList.size() + "건 저장 성공");
        return messenger;
    }

    public Messenger update(TeamDTO team) {
        TeamEntity entity = toEntity(team);
        entityManager.merge(entity);

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("팀 정보 수정 성공");
        return messenger;
    }

    public Messenger delete(TeamDTO teamDTO) {
        if (teamDTO.getTeamId() != null) {
            TeamEntity entity = entityManager.find(TeamEntity.class, teamDTO.getTeamId());
            if (entity != null) {
                entityManager.remove(entity);
            }
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("팀 정보 삭제 성공");
        return messenger;
    }

    public Messenger findById(TeamDTO teamDTO) {
        if (teamDTO.getTeamId() != null) {
            entityManager.find(TeamEntity.class, teamDTO.getTeamId());
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("팀 정보 조회 성공");
        return messenger;
    }

    public List<TeamDTO> findAll() {
        List<TeamEntity> entities = entityManager.createQuery(
                "SELECT t FROM TeamEntity t", TeamEntity.class)
                .getResultList();

        List<TeamDTO> teamList = new ArrayList<>();
        for (TeamEntity entity : entities) {
            teamList.add(toDTO(entity));
        }
        return teamList;
    }

    private TeamEntity toEntity(TeamDTO dto) {
        return new TeamEntity(
                dto.getTeamId(),
                dto.getRegionName(),
                dto.getTeamName(),
                dto.getETeamName(),
                dto.getOrigYyyy(),
                dto.getZipCode1(),
                dto.getZipCode2(),
                dto.getAddress(),
                dto.getDdd(),
                dto.getTel(),
                dto.getFax(),
                dto.getHomepage(),
                dto.getOwner(),
                dto.getStadiumId());
    }

    private TeamDTO toDTO(TeamEntity entity) {
        return new TeamDTO(
                entity.getTeamId(),
                entity.getRegionName(),
                entity.getTeamName(),
                entity.getETeamName(),
                entity.getOrigYyyy(),
                entity.getZipCode1(),
                entity.getZipCode2(),
                entity.getAddress(),
                entity.getDdd(),
                entity.getTel(),
                entity.getFax(),
                entity.getHomepage(),
                entity.getOwner(),
                entity.getStadiumId());
    }
}

