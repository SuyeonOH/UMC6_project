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
import umc.mission7.converter.MissionConverter;
import umc.mission7.service.MissionQueryService;
import umc.mission7.validation.annotation.ExistMember;
import umc.mission7.validation.annotation.ExistPage;
import umc.mission7.web.dto.MissionResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionQueryService missionQueryService;

//    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
//    @GetMapping("/{storeId}/missions")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "INVALID_PAGE", description = "유효하지 않은 페이지 번호", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
//    })
//    @Parameters({
//            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
//            @Parameter(name = "page", description = "페이지 번호, 1 이상의 페이지 번호를 쿼리 스트링으로 전달해주세요")
//    })
//    public ApiResponse<MissionResponseDTO.MissionListDTO> getMissionsByStoreId(@PathVariable(name = "storeId") Long storeId, @ExistPage @RequestParam(name = "page") Integer page) {
//        var missions = missionQueryService.getMissionsByStoreId(storeId, page - 1);  // 페이지 번호를 0부터 시작하도록 조정
//        return ApiResponse.onSuccess(MissionConverter.toMissionListDTO(missions));
//    }


    @Operation(summary = "진행 중인 미션 목록 조회 API", description = "특정 사용자가 진행 중인 미션 목록을 조회하는 API입니다. 페이지 번호를 지정하여 조회할 수 있습니다.")
    @GetMapping("/my")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디"),
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 값을 가져야 합니다.")
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getMyMissions(
            @ExistMember @RequestParam(name = "memberId") Long memberId,
            @ExistPage @RequestParam(name = "page") Integer page) {

        final int PAGE_SIZE = 10;
        var missions = missionQueryService.getMyMissions(memberId, page - 1, PAGE_SIZE);
        var missionListDTO = MissionConverter.toMissionListDTO(missions);
        return ApiResponse.onSuccess(missionListDTO);
    }
}
