package umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    private String id;

    private String store;

    private String information;

    private String point;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;
}