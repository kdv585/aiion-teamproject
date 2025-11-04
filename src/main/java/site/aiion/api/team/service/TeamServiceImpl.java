package site.aiion.api.team.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.team.domain.TeamDTO;
import site.aiion.api.team.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public Messenger save(TeamDTO teamDTO) {
        return teamRepository.save(teamDTO);
    }

    @Override
    public Messenger update(TeamDTO teamDTO) {
        return teamRepository.update(teamDTO);
    }

    @Override
    public Messenger delete(TeamDTO teamDTO) {
        return teamRepository.delete(teamDTO);
    }

    @Override
    public Messenger findById(TeamDTO teamDTO) {
        return teamRepository.findById(teamDTO);
    }

    @Override
    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("팀 목록 조회 성공");
        return messenger;
    }

    @Override
    public List<TeamDTO> getTeams() {
        return teamRepository.findAll();
    }

}

