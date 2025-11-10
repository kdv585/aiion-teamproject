package site.aiion.api.soccer.team.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.soccer.team.domain.TeamDTO;

@Repository
public class TeamRepository {

    public Messenger save(TeamDTO team) {
        return new Messenger(0, "팀 정보 저장 성공");
    }

    public Messenger update(TeamDTO team) {
        return new Messenger(0, "팀 정보 수정 성공");
    }

    public Messenger delete(TeamDTO team) {
        return new Messenger(0, "팀 정보 삭제 성공");
    }

    public Messenger findById(TeamDTO team) {
        return new Messenger(0, "팀 정보 조회 성공");
    }

    public List<TeamDTO> findAll() {
        List<TeamDTO> teamList = new ArrayList<>();
        teamList.add(new TeamDTO());
        teamList.add(new TeamDTO());
        return teamList;
    }
}
