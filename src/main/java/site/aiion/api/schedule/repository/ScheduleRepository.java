package site.aiion.api.schedule.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.schedule.domain.ScheduleDTO;

@Repository
public class ScheduleRepository {

    public Messenger save(ScheduleDTO schedule) {
        return new Messenger(0, "일정 정보 저장 성공");
    }

    public Messenger update(ScheduleDTO schedule) {
        return new Messenger(0, "일정 정보 수정 성공");
    }

    public Messenger delete(ScheduleDTO schedule) {
        return new Messenger(0, "일정 정보 삭제 성공");
    }

    public Messenger findById(ScheduleDTO schedule) {
        return new Messenger(0, "일정 정보 조회 성공");
    }

    public List<ScheduleDTO> findAll() {
        List<ScheduleDTO> scheduleList = new ArrayList<>();
        scheduleList.add(new ScheduleDTO());
        scheduleList.add(new ScheduleDTO());
        return scheduleList;
    }
}