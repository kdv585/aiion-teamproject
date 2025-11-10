package site.aiion.api.soccer.player.service;

import java.util.List;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.soccer.player.domain.PlayerDTO;

public interface PlayerService {

    Messenger save(PlayerDTO playerDTO);

    Messenger update(PlayerDTO playerDTO);

    Messenger delete(PlayerDTO playerDTO);

    Messenger findById(PlayerDTO playerDTO);

    Messenger findAll();

    List<PlayerDTO> getPlayers();

    Messenger findByKeyword(String keyword);

}
