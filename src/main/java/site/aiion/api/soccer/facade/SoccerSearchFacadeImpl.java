package site.aiion.api.soccer.facade;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.aiion.api.common.domain.Messenger;
import site.aiion.api.soccer.player.service.PlayerService;
import site.aiion.api.soccer.schedule.service.ScheduleService;
import site.aiion.api.soccer.stadium.service.StadiumService;
import site.aiion.api.soccer.team.service.TeamService;

@Service
@RequiredArgsConstructor
public class SoccerSearchFacadeImpl implements SoccerSearchFacade {

    private final PlayerService playerService;
    private final ScheduleService scheduleService;
    private final StadiumService stadiumService;
    private final TeamService teamService;

    @Override
    public Messenger searchByKeyword(String keyword, String entityType) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new Messenger(-1, "검색어를 입력해주세요.");
        }

        // 엔티티 타입에 따라 적절한 서비스로 라우팅
        switch (entityType != null ? entityType.toLowerCase() : "") {
            case "player":
            case "players":
                return playerService.findByKeyword(keyword);

            case "schedule":
            case "schedules":
                return scheduleService.findByKeyword(keyword);

            case "stadium":
            case "stadiums":
                return stadiumService.findByKeyword(keyword);

            case "team":
            case "teams":
                return teamService.findByKeyword(keyword);

            default:
                // 엔티티 타입이 명시되지 않은 경우 모든 서비스에서 검색
                playerService.findByKeyword(keyword);
                scheduleService.findByKeyword(keyword);
                stadiumService.findByKeyword(keyword);
                teamService.findByKeyword(keyword);

                return new Messenger(0, "전체 검색 완료 - 검색어: " + keyword);
        }
    }
}
