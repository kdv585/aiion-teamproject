package site.aiion.api.diary.service;

import java.util.List;

import site.aiion.api.common.Messenger;
import site.aiion.api.diary.domain.DiaryDTO;

public interface DiaryService {

    Messenger save(DiaryDTO diaryDTO);

    Messenger update(DiaryDTO diaryDTO);

    Messenger delete(DiaryDTO diaryDTO);

    Messenger findById(DiaryDTO diaryDTO);

    Messenger findAll();

    List<DiaryDTO> getDiaries();

}
