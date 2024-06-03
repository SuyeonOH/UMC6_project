package umc.mission7.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.mission7.apiPayload.ApiResponse;
import umc.mission7.service.MissionQueryService;
import umc.mission7.validation.annotation.ExistMember;
import umc.mission7.validation.annotation.ExistMission;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionCompletionController {

    private final MissionQueryService missionService;

    @Operation(summary = "진행 중인 미션 완료 API", description = "진행 중인 미션을 완료 상태로 변경하는 API입니다.")
    @PutMapping("/{missionId}/complete")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION_NOT_FOUND", description = "미션을 찾을 수 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION_ALREADY_COMPLETED", description = "미션은 이미 완료되었습니다", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다!"),
            @Parameter(name = "memberId", description = "사용자의 아이디, query parameter입니다.")
    })
    public ApiResponse<String> completeMission(
            @ExistMission @PathVariable(name = "missionId") Long missionId,
            @ExistMember @RequestParam(name = "memberId") Long memberId) {
        missionService.completeMission(missionId, memberId);
        return ApiResponse.onSuccess("Mission completed successfully");
    }
}
