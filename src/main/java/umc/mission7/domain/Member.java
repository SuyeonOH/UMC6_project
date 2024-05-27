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
public class Member extends BaseEntity{

    @Id
    private String id;

    private String name;

    private String gender;

    private LocalDate birthdate;

    private String address;

//    private LocalDate createdAt;

//    private LocalDate updatedAt;

    private String status;

    private LocalDate inactiveDate;

    private String specAddress;

    private String socialType;

    @OneToMany(mappedBy = "member")
    private List<Flavor> flavors;

    @OneToMany(mappedBy = "member")
    private List<Store> stores;

    @OneToMany(mappedBy = "member")
    private List<Alarm> alarms;

    @OneToMany(mappedBy = "member")
    private List<Ask> asks;
}