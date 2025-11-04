package site.aiion.api.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import site.aiion.api.common.domain.Messenger;

@RestController
@Tag(name = "Home", description = "홈 API")
public class HomeController {

    @Operation(summary = "홈 페이지 조회", description = "API 서버의 상태를 확인하는 엔드포인트입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API 서버가 정상적으로 실행 중입니다.")
    })
    @GetMapping("/")
    public Messenger home() {
        return Messenger.builder()
                .code(200)
                .message("성공")
                .build();
    }
}
