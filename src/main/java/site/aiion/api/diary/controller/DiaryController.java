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
        return diaryService.save(diaryDTO);
    }

    @PutMapping
    public Messenger update(@RequestBody DiaryDTO diaryDTO) {
        return diaryService.update(diaryDTO);
    }

    @DeleteMapping
    public Messenger delete(@RequestBody DiaryDTO diaryDTO) {
        return diaryService.delete(diaryDTO);
    }

    @PostMapping("/find")
    public Messenger findById(@RequestBody DiaryDTO diaryDTO) {
        return diaryService.findById(diaryDTO);
    }

    @GetMapping
    public Messenger findAll() {
        return diaryService.findAll();
    }

    @GetMapping("/list")
    public List<DiaryDTO> getDiaries() {
        return diaryService.getDiaries();
    }

}
