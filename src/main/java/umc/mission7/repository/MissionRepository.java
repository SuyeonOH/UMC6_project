package umc.mission7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission7.domain.Mission;
import umc.mission7.domain.Store;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
    Page<Mission> findById(Long memberId, PageRequest pageRequest);
//    Mission findByIdAsLong(Long id);
}
