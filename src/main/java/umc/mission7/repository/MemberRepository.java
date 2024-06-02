package umc.mission7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission7.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
