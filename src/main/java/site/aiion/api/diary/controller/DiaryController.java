package site.aiion.api.diary.controller;

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
import site.aiion.api.diary.domain.DiaryDTO;
import site.aiion.api.diary.service.DiaryService;

@RestController
@RequestMapping("diaries")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public Messenger save(@RequestBody DiaryDTO diaryDTO) {
        diaryService.save(diaryDTO);
        return new Messenger(0, "일기 정보 저장 성공");
    }

    @PutMapping
    public Messenger update(@RequestBody DiaryDTO diaryDTO) {
        diaryService.update(diaryDTO);
        return new Messenger(0, "일기 정보 수정 성공");
    }

    @DeleteMapping
    public Messenger delete(@RequestBody DiaryDTO diaryDTO) {
        diaryService.delete(diaryDTO);
        return new Messenger(0, "일기 정보 삭제 성공");
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody DiaryDTO diaryDTO) {
        diaryService.findById(diaryDTO);
        return new Messenger(0, "일기 정보 조회 성공");
    }

    @GetMapping
    public Messenger findAll() {
        diaryService.findAll();
        return new Messenger(0, "일기 목록 조회 성공");
    }

    @GetMapping("/list")
    public List<DiaryDTO> getDiaries() {
        return diaryService.getDiaries();
    }

}
