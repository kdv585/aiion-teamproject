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
        return stadiumService.save(stadiumDTO);
    }

    @PutMapping
    public Messenger update(@RequestBody StadiumDTO stadiumDTO) {
        return stadiumService.update(stadiumDTO);
    }

    @DeleteMapping
    public Messenger delete(@RequestBody StadiumDTO stadiumDTO) {
        return stadiumService.delete(stadiumDTO);
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody StadiumDTO stadiumDTO) {
        return stadiumService.findById(stadiumDTO);
    }

    @GetMapping
    public Messenger findAll() {
        return stadiumService.findAll();
    }

    @GetMapping("/list")
    public List<StadiumDTO> getStadiums() {
        return stadiumService.getStadiums();
    }

}

