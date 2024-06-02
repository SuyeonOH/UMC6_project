package umc.mission7.service.MemberService;

import umc.mission7.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

}
