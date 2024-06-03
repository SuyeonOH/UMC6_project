package umc.mission7.converter;

import org.springframework.data.domain.Page;
import umc.mission7.domain.Review;
import umc.mission7.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static StoreResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList) {

        List<StoreResponseDTO.ReviewPreViewDTO> reviewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreViewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewDTOList.size())
                .reviewList(reviewDTOList)
                .build();
    }
}
