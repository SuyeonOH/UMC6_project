package umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flavor {

    @Id
    private String id;

    private String food;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;
}
