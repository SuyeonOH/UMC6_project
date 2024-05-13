package umc.mission7.domain.enums.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.mission7.domain.common.BaseEntity;
import umc.mission7.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
}
