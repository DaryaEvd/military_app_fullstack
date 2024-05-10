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

    /// todo: think
//    @OneToMany(mappedBy = "subdivision")
//    private List<Commander> commanders;
    ///


    @ManyToMany
    @JoinTable(
//            name = "subdivision_soldier",
            name = "commander_table",
            joinColumns = @JoinColumn(name = "subdivision_id"),
            inverseJoinColumns = @JoinColumn(name = "soldier_id")
    )
    private List<Soldier> soldiers;


//
//    @ManyToMany(mappedBy = "soldiers")
//    private List<Subdivision> subdivisions;


    @Column(name = "number_of_subdivision", nullable = false)
    private Integer numberOfSubdivision;

    @Column(name = "dislocated", nullable = false)
    private Boolean isDislocated;

    @Column(name = "commander", nullable = false)
    private Integer commander; // TODO: think about reference?

//    @Column(name = "type_of_subdivision", nullable = false)
//    private Integer typeOfSubdivision; // TODO: think about reference?

    @ManyToOne
    @JoinColumn(name = "type_of_subdivision", referencedColumnName = "id", nullable = false)
    private SubdivisionType typeOfSubdivision;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subdivision")
    private List<MilitaryBuilding> militaryBuildings;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subdivision")
    private List<CombatEquipment> combatEquipments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subdivision")
    private List<WeaponType> weaponTypes;
//
//    @ManyToMany(mappedBy = "subdivisions")
//    private List<Soldier> soldiers;
}
