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
public class Review extends BaseEntity {

    @Id
    private String id;

    private String title;

    private String description;

    private String photo;

    private String rating;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "alarm_id")
    private Alarm alarm;
}