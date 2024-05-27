package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    private String typeOfBuilding;

    @Column(name = "area_of_building", nullable = false)
    private Integer areaOfBuilding;

    @Column(name = "amount_of_rooms", nullable = false)
    private Integer amountOfRooms;

    @ManyToMany
    @JoinTable(
            name = "military_building_subdivision",
            joinColumns = @JoinColumn(name = "military_building_id"),
            inverseJoinColumns = @JoinColumn(name = "subdivision_id")
    )
    private List<Subdivision> subdivisions = new ArrayList<>();

}
