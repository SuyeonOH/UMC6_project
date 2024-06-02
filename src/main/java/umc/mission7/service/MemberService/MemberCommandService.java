package umc.mission7.service.MemberService;

import umc.mission7.domain.Member;
import umc.mission7.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
