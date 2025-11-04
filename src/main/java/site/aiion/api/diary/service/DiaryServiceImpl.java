package site.aiion.api.diary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import site.aiion.api.common.domain.Messenger;
import site.aiion.api.diary.domain.DiaryDTO;
import site.aiion.api.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Override
    public Messenger save(DiaryDTO diaryDTO) {
        return diaryRepository.save(diaryDTO);
    }

    @Override
    public Messenger update(DiaryDTO diaryDTO) {
        return diaryRepository.update(diaryDTO);
    }

    @Override
    public Messenger delete(DiaryDTO diaryDTO) {
        return diaryRepository.delete(diaryDTO);
    }

    @Override
    public Messenger findById(DiaryDTO diaryDTO) {
        return diaryRepository.findById(diaryDTO);
    }

    @Override
    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 목록 조회 성공");
        return messenger;
    }

    @Override
    public List<DiaryDTO> getDiaries() {
        return diaryRepository.findAll();
    }

}
