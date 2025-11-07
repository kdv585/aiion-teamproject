package site.aiion.api.stadium.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.stadium.domain.StadiumDTO;

@Repository
public class StadiumRepository {

    public Messenger save(StadiumDTO stadium) {
        return new Messenger(0, "경기장 정보 저장 성공");
    }

    public Messenger update(StadiumDTO stadium) {
        return new Messenger(0, "경기장 정보 수정 성공");
    }

    public Messenger delete(StadiumDTO stadium) {
        return new Messenger(0, "경기장 정보 삭제 성공");
    }

    public Messenger findById(StadiumDTO stadium) {
        return new Messenger(0, "경기장 정보 조회 성공");
    }

    public List<StadiumDTO> findAll() {
        List<StadiumDTO> stadiumList = new ArrayList<>();
        stadiumList.add(new StadiumDTO());
        stadiumList.add(new StadiumDTO());
        return stadiumList;
    }
}
