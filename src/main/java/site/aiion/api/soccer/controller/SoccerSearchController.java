package site.aiion.api.soccer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.soccer.facade.SoccerSearchFacade;

@RestController
@RequestMapping("/api/soccer/search")
@RequiredArgsConstructor
public class SoccerSearchController {

    private final SoccerSearchFacade soccerSearchFacade;

    @GetMapping("/findByKeyword")
    public Messenger findByKeyword(
            @RequestParam String keyword,
            @RequestParam(required = false) String entityType) {

        System.out.println("=== 파사드 패턴: 검색 요청 수신 ===");
        System.out.println("검색어: " + keyword);
        System.out.println("엔티티 타입: " + entityType);
        System.out.println("================================");

        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("[경고] 검색어가 비어있습니다.");
            return new Messenger(-1, "검색어를 입력해주세요.");
        }

        // 엔티티 타입에 따라 적절한 서비스로 라우팅
        String lowerEntityType = entityType != null ? entityType.toLowerCase() : "";
        switch (lowerEntityType) {
            case "player":
            case "players":
                System.out.println("→ PlayerService로 라우팅");
                break;
            case "schedule":
            case "schedules":
                System.out.println("→ ScheduleService로 라우팅");
                break;
            case "stadium":
            case "stadiums":
                System.out.println("→ StadiumService로 라우팅");
                break;
            case "team":
            case "teams":
                System.out.println("→ TeamService로 라우팅");
                break;
            default:
                System.out.println("[경고] 알 수 없는 엔티티 타입: " + entityType);
                System.out.println("→ 모든 서비스에서 검색 시도");
                System.out.println("→ PlayerService 검색");
                System.out.println("→ ScheduleService 검색");
                System.out.println("→ StadiumService 검색");
                System.out.println("→ TeamService 검색");
                break;
        }

        return soccerSearchFacade.searchByKeyword(keyword, entityType);
    }
}
