package site.aiion.api.soccer.schedule.service;

import java.util.List;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.soccer.schedule.domain.ScheduleDTO;

public interface ScheduleService {

    Messenger save(ScheduleDTO scheduleDTO);

    Messenger update(ScheduleDTO scheduleDTO);

    Messenger delete(ScheduleDTO scheduleDTO);

    Messenger findById(ScheduleDTO scheduleDTO);

    Messenger findAll();

    List<ScheduleDTO> getSchedules();

    Messenger findByKeyword(String keyword);

}

