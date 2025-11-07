package site.aiion.api.stadium.controller;

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
import site.aiion.api.stadium.domain.StadiumDTO;
import site.aiion.api.stadium.service.StadiumService;

@RestController
@RequestMapping("stadiums")
@RequiredArgsConstructor
public class StadiumController {

    private final StadiumService stadiumService;

    @PostMapping
    public Messenger save(@RequestBody StadiumDTO stadiumDTO) {
        stadiumService.save(stadiumDTO);
        return new Messenger(0, "경기장 정보 저장 성공");
    }

    @PutMapping
    public Messenger update(@RequestBody StadiumDTO stadiumDTO) {
        stadiumService.update(stadiumDTO);
        return new Messenger(0, "경기장 정보 수정 성공");
    }

    @DeleteMapping
    public Messenger delete(@RequestBody StadiumDTO stadiumDTO) {
        stadiumService.delete(stadiumDTO);
        return new Messenger(0, "경기장 정보 삭제 성공");
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody StadiumDTO stadiumDTO) {
        stadiumService.findById(stadiumDTO);
        return new Messenger(0, "경기장 정보 조회 성공");
    }

    @GetMapping
    public Messenger findAll() {
        stadiumService.findAll();
        return new Messenger(0, "경기장 목록 조회 성공");
    }

    @GetMapping("/list")
    public List<StadiumDTO> getStadiums() {
        return stadiumService.getStadiums();
    }

}
