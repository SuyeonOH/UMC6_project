package umc.mission7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission7.domain.Member;
import umc.mission7.domain.Mission;
import umc.mission7.domain.Store;
import umc.mission7.domain.enums.MissionStatus;
import umc.mission7.repository.MemberRepository;
import umc.mission7.repository.MissionRepository;
import umc.mission7.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<Mission> getMissionsByStoreId(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("Store not found"));
        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getMyMissions(Long memberId, Integer page, Integer size) {
        return missionRepository.findById(memberId, PageRequest.of(page, size));
    }

    @Override
    public void completeMission(Long missionId, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        if (mission.getStatus() == MissionStatus.COMPLETE) {
            throw new IllegalStateException("Mission is already completed");
        }

        mission.setStatus(MissionStatus.COMPLETE);
        mission.setCompletedBy(member);

        missionRepository.save(mission);
    }

}
