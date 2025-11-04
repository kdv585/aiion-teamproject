package site.aiion.api.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.schedule.domain.ScheduleDTO;
import site.aiion.api.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public Messenger save(ScheduleDTO scheduleDTO) {
        return scheduleRepository.save(scheduleDTO);
    }

    @Override
    public Messenger update(ScheduleDTO scheduleDTO) {
        return scheduleRepository.update(scheduleDTO);
    }

    @Override
    public Messenger delete(ScheduleDTO scheduleDTO) {
        return scheduleRepository.delete(scheduleDTO);
    }

    @Override
    public Messenger findById(ScheduleDTO scheduleDTO) {
        return scheduleRepository.findById(scheduleDTO);
    }

    @Override
    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일정 목록 조회 성공");
        return messenger;
    }

    @Override
    public List<ScheduleDTO> getSchedules() {
        return scheduleRepository.findAll();
    }

}

