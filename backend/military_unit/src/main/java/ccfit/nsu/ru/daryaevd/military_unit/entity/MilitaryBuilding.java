package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "military_building_table")
public class MilitaryBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "can_use_for_dislocation", nullable = false)
    private Boolean canUseForDislocation;

    @Column(name = "type_of_building", nullable = false)
    private Integer typeOfBuilding;

    @Column(name = "area_of_building", nullable = false)
    private Boolean areaOfBuilding;

    @Column(name = "amount_of_rooms", nullable = false)
    private Integer amountOfRooms;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "militaryBuilding", cascade = CascadeType.ALL)
    private List<Subdivision> subdivisionList;
}
