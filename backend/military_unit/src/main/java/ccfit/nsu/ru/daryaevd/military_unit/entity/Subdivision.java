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
@Table(name = "subdivision_table")
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_subdivision", nullable = false)
    private String nameOfSubdivision;

    @OneToMany(mappedBy = "subdivision", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Soldier> soldiers = new ArrayList<>();

    @Column(name = "number_of_subdivision", nullable = false)
    private Integer numberOfSubdivision;

    @Column(name = "dislocated", nullable = false)
    private Boolean isDislocated;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commander_id", referencedColumnName = "id")
    private Soldier commander;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_of_subdivision_id", referencedColumnName = "id", nullable = false)
    private SubdivisionType typeOfSubdivision;

//    @OneToMany(mappedBy = "subdivision", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<MilitaryBuilding> militaryBuildings = new ArrayList<>();

    @ManyToMany(mappedBy = "subdivisions")
    private List<MilitaryBuilding> militaryBuildings = new ArrayList<>();

}
