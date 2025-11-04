package site.aiion.api.player.service;

import java.util.List;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.player.domain.PlayerDTO;

public interface PlayerService {

    Messenger save(PlayerDTO playerDTO);

    Messenger update(PlayerDTO playerDTO);

    Messenger delete(PlayerDTO playerDTO);

    Messenger findById(PlayerDTO playerDTO);

    Messenger findAll();

    List<PlayerDTO> getPlayers();

}
