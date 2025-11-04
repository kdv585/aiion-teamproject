package site.aiion.api.schedule.controller;

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
import site.aiion.api.schedule.domain.ScheduleDTO;
import site.aiion.api.schedule.service.ScheduleService;

@RestController
@RequestMapping("schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public Messenger save(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.save(scheduleDTO);
    }

    @PutMapping
    public Messenger update(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.update(scheduleDTO);
    }

    @DeleteMapping
    public Messenger delete(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.delete(scheduleDTO);
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.findById(scheduleDTO);
    }

    @GetMapping
    public Messenger findAll() {
        return scheduleService.findAll();
    }

    @GetMapping("/list")
    public List<ScheduleDTO> getSchedules() {
        return scheduleService.getSchedules();
    }

}

