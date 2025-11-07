package site.aiion.api.player.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.player.domain.PlayerDTO;
import site.aiion.api.player.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public Messenger save(PlayerDTO playerDTO) {
        return playerRepository.save(playerDTO);
    }

    @Override
    public Messenger update(PlayerDTO playerDTO) {
        return playerRepository.update(playerDTO);
    }

    @Override
    public Messenger delete(PlayerDTO playerDTO) {
        return playerRepository.delete(playerDTO);
    }

    @Override
    public Messenger findById(PlayerDTO playerDTO) {
        return playerRepository.findById(playerDTO);
    }

    @Override
    public Messenger findAll() {
        return new Messenger(0, "선수 목록 조회 성공");
    }

    @Override
    public List<PlayerDTO> getPlayers() {
        return playerRepository.findAll();
    }

}
