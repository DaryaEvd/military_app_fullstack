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
@Table(name = "subdivision_table")
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_subdivision", nullable = false)
    private String nameOfSubdivision;

    @Column(name = "number_of_subdivision", nullable = false)
    private Integer numberOfSubdivision;

    @Column(name = "dislocated", nullable = false)
    private Boolean isDislocated;

    @Column(name = "commander", nullable = false)
    private Integer commander; // TODO: think about reference?

    @Column(name = "type_of_subdivision", nullable = false)
    private Integer typeOfSubdivision; // TODO: think about reference?


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subdivision")
    private List<MilitaryBuilding> militaryBuildings;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subdivision")
    private List<CombatEquipment> combatEquipments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subdivision")
    private List<WeaponType> weaponTypes;
}
