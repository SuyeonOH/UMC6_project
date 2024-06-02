package umc.mission7.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission7.apiPayload.code.status.ErrorStatus;
import umc.mission7.apiPayload.exception.handler.FoodCategoryHandler;
import umc.mission7.converter.MemberConverter;
import umc.mission7.converter.MemberPreferConverter;
import umc.mission7.domain.FoodCategory;
import umc.mission7.domain.Member;
import umc.mission7.domain.mapping.MemberPrefer;
import umc.mission7.repository.FoodCategoryRepository;
import umc.mission7.repository.MemberRepository;
import umc.mission7.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
