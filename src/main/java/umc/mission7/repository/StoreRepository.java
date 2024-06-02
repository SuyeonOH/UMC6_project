package umc.mission7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission7.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
