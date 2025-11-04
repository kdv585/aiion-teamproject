package site.aiion.api.team.service;

import java.util.List;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.team.domain.TeamDTO;

public interface TeamService {

    Messenger save(TeamDTO teamDTO);

    Messenger update(TeamDTO teamDTO);

    Messenger delete(TeamDTO teamDTO);

    Messenger findById(TeamDTO teamDTO);

    Messenger findAll();

    List<TeamDTO> getTeams();

}

