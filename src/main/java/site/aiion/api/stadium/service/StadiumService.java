package site.aiion.api.stadium.service;

import java.util.List;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.stadium.domain.StadiumDTO;

public interface StadiumService {

    Messenger save(StadiumDTO stadiumDTO);

    Messenger update(StadiumDTO stadiumDTO);

    Messenger delete(StadiumDTO stadiumDTO);

    Messenger findById(StadiumDTO stadiumDTO);

    Messenger findAll();

    List<StadiumDTO> getStadiums();

}

