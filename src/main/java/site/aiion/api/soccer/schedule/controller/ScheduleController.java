package site.aiion.api.soccer.schedule.controller;

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
import site.aiion.api.soccer.schedule.domain.ScheduleDTO;
import site.aiion.api.soccer.schedule.service.ScheduleService;

@RestController
@RequestMapping("schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public Messenger save(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.save(scheduleDTO);
        return new Messenger(0, "일정 정보 저장 성공");
    }

    @PutMapping
    public Messenger update(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.update(scheduleDTO);
        return new Messenger(0, "일정 정보 수정 성공");
    }

    @DeleteMapping
    public Messenger delete(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.delete(scheduleDTO);
        return new Messenger(0, "일정 정보 삭제 성공");
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.findById(scheduleDTO);
        return new Messenger(0, "일정 정보 조회 성공");
    }

    @GetMapping
    public Messenger findAll() {
        scheduleService.findAll();
        return new Messenger(0, "일정 목록 조회 성공");
    }

    @GetMapping("/list")
    public List<ScheduleDTO> getSchedules() {
        return scheduleService.getSchedules();
    }

}

