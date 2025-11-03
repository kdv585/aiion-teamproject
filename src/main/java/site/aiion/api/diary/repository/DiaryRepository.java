package site.aiion.api.diary.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import site.aiion.api.common.Messenger;
import site.aiion.api.diary.domain.DiaryDTO;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {
    public Messenger save(DiaryDTO diary) {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 저장 성공");
        return messenger;
    }

    public Messenger saveAll(List<DiaryDTO> diary) {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 저장 성공");
        return messenger;
    }

    public Messenger update(DiaryDTO diary) {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 수정 성공");
        return messenger;
    }

    public Messenger delete(DiaryDTO diaryDTO) {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 삭제 성공");
        return messenger;
    }

    public Messenger findById(DiaryDTO diaryDTO) {
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("일기 정보 조회 성공");
        return messenger;
    }

    public List<DiaryDTO> findAll() {
        List<DiaryDTO> diaryList = new ArrayList<>();
        diaryList.add(new DiaryDTO());
        diaryList.add(new DiaryDTO());
        return diaryList;
    }
}