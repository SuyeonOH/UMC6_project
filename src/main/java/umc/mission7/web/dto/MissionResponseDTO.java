package umc.mission7.web.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MissionDTO {
        private Long id;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MissionListDTO {
        private List<MissionDTO> missions;
        private int pageSize;
        private int totalPages;
        private long totalElements;
        private boolean isFirst;
        private boolean isLast;
    }
}
