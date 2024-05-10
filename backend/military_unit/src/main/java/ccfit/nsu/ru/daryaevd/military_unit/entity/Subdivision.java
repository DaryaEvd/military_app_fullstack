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

    @ManyToMany
    @JoinTable(
            name = "commander_table",
            joinColumns = @JoinColumn(name = "subdivision_id"),
            inverseJoinColumns = @JoinColumn(name = "soldier_id")
    )
    private List<Soldier> soldiers;

    @Column(name = "number_of_subdivision", nullable = false)
    private Integer numberOfSubdivision;

    @Column(name = "dislocated", nullable = false)
    private Boolean isDislocated;

    @Column(name = "commander", nullable = false)
    private Integer commander; // TODO: think about reference?

    @ManyToOne
    @JoinColumn(name = "type_of_subdivision", referencedColumnName = "id", nullable = false)
    private SubdivisionType typeOfSubdivision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "military_building", /*referencedColumnName = "id",*/ nullable = false)
    private MilitaryBuilding militaryBuilding;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "combat_equipment", /*referencedColumnName = "id",*/ nullable = false)
    private CombatEquipment combatEquipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_type", /*referencedColumnName = "id",*/ nullable = false)
    private WeaponType weaponType;
}
