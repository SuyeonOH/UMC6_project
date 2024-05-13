package umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.mission7.domain.common.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alarm extends BaseEntity {

    @Id
    private String id;

    private String isConfirmed;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;
}
