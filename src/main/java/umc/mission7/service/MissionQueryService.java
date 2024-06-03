package umc.mission7.service;

import org.springframework.data.domain.Page;
import umc.mission7.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMissionsByStoreId(Long storeId, Integer page);

    Page<Mission> getMyMissions(Long memberId, Integer page, Integer size);

    void completeMission(Long missionId, Long memberId);
}
