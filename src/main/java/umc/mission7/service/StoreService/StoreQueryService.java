package umc.mission7.service.StoreService;

import umc.mission7.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
}
