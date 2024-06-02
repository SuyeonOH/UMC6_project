package umc.mission7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission7.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
