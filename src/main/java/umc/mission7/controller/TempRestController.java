package umc.mission7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.mission7.apiPayload.ApiResponse;
import umc.mission7.converter.TempConverter;
import umc.mission7.service.TempService.TempQueryService;
import umc.mission7.web.dto.TempResponse;


@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
