package site.aiion.api.soccer.player.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.soccer.player.domain.PlayerDTO;

@Repository
public class PlayerRepository {

    public Messenger save(PlayerDTO player) {
        return new Messenger(0, "선수 정보 저장 성공");
    }

    public Messenger update(PlayerDTO player) {
        return new Messenger(0, "선수 정보 수정 성공");
    }

    public Messenger delete(PlayerDTO player) {
        return new Messenger(0, "선수 정보 삭제 성공");
    }

    public Messenger findById(PlayerDTO player) {
        return new Messenger(0, "선수 정보 조회 성공");
    }

    public List<PlayerDTO> findAll() {
        List<PlayerDTO> playerList = new ArrayList<>();
        playerList.add(new PlayerDTO());
        playerList.add(new PlayerDTO());
        return playerList;
    }
}
