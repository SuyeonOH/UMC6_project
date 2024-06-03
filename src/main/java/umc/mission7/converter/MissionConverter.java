package umc.mission7.converter;

import org.springframework.data.domain.Page;
import umc.mission7.domain.Mission;
import umc.mission7.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return MissionResponseDTO.MissionDTO.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static List<MissionResponseDTO.MissionDTO> toMissionDTOList(List<Mission> missionList) {
        return missionList.stream()
                .map(MissionConverter::toMissionDTO)
                .collect(Collectors.toList());
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missions) {
        List<MissionResponseDTO.MissionDTO> missionDTOList = toMissionDTOList(missions.getContent());

        return MissionResponseDTO.MissionListDTO.builder()
                .missions(missionDTOList)
                .pageSize(missions.getSize())
                .totalPages(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }
}
