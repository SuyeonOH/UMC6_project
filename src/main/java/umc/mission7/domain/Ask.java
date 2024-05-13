package umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.mission7.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ask extends BaseEntity {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    private String title;

    private String description;

    private String photo;
}
