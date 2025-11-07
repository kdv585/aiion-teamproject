package site.aiion.api.player.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.player.domain.PlayerDTO;
import site.aiion.api.player.service.PlayerService;

@RestController
@RequestMapping("players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public Messenger save(@RequestBody PlayerDTO playerDTO) {
        playerService.save(playerDTO);
        return new Messenger(0, "선수 정보 저장 성공");
    }

    @PutMapping
    public Messenger update(@RequestBody PlayerDTO playerDTO) {
        playerService.update(playerDTO);
        return new Messenger(0, "선수 정보 수정 성공");
    }

    @DeleteMapping
    public Messenger delete(@RequestBody PlayerDTO playerDTO) {
        playerService.delete(playerDTO);
        return new Messenger(0, "선수 정보 삭제 성공");
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody PlayerDTO playerDTO) {
        playerService.findById(playerDTO);
        return new Messenger(0, "선수 정보 조회 성공");
    }

    @GetMapping
    public Messenger findAll() {
        playerService.findAll();
        return new Messenger(0, "선수 목록 조회 성공");
    }

    @GetMapping("/list")
    public List<PlayerDTO> getPlayers() {
        return playerService.getPlayers();
    }

}
