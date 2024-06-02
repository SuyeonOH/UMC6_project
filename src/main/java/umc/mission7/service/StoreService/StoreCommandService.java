package umc.mission7.service.StoreService;

import umc.mission7.domain.Review;
import umc.mission7.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);
}
