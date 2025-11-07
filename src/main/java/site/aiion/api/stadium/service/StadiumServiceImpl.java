package site.aiion.api.stadium.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.stadium.domain.StadiumDTO;
import site.aiion.api.stadium.repository.StadiumRepository;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService {

    private final StadiumRepository stadiumRepository;

    @Override
    public Messenger save(StadiumDTO stadiumDTO) {
        return stadiumRepository.save(stadiumDTO);
    }

    @Override
    public Messenger update(StadiumDTO stadiumDTO) {
        return stadiumRepository.update(stadiumDTO);
    }

    @Override
    public Messenger delete(StadiumDTO stadiumDTO) {
        return stadiumRepository.delete(stadiumDTO);
    }

    @Override
    public Messenger findById(StadiumDTO stadiumDTO) {
        return stadiumRepository.findById(stadiumDTO);
    }

    @Override
    public Messenger findAll() {
        return new Messenger(0, "경기장 목록 조회 성공");
    }

    @Override
    public List<StadiumDTO> getStadiums() {
        return stadiumRepository.findAll();
    }

}

