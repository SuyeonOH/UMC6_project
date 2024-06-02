package umc.mission7.service.StoreService;

import org.springframework.data.domain.Page;
import umc.mission7.domain.Review;
import umc.mission7.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
