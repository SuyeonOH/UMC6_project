package umc.mission7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission7.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
