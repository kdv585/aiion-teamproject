package site.aiion.api.team.controller;

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
import site.aiion.api.team.domain.TeamDTO;
import site.aiion.api.team.service.TeamService;

@RestController
@RequestMapping("teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public Messenger save(@RequestBody TeamDTO teamDTO) {
        teamService.save(teamDTO);
        return new Messenger(0, "팀 정보 저장 성공");
    }

    @PutMapping
    public Messenger update(@RequestBody TeamDTO teamDTO) {
        teamService.update(teamDTO);
        return new Messenger(0, "팀 정보 수정 성공");
    }

    @DeleteMapping
    public Messenger delete(@RequestBody TeamDTO teamDTO) {
        teamService.delete(teamDTO);
        return new Messenger(0, "팀 정보 삭제 성공");
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody TeamDTO teamDTO) {
        teamService.findById(teamDTO);
        return new Messenger(0, "팀 정보 조회 성공");
    }

    @GetMapping
    public Messenger findAll() {
        teamService.findAll();
        return new Messenger(0, "팀 목록 조회 성공");
    }

    @GetMapping("/list")
    public List<TeamDTO> getTeams() {
        return teamService.getTeams();
    }

}
