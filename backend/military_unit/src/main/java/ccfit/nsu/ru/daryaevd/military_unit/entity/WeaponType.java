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
@Table(name = "weapon_type_table")
public class WeaponType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_type", nullable = false)
    private String nameOfType;

    @Column(name = "experience_of_using", nullable = false)
    private Integer experienceOfUsing;

    @Column(name = "condition_of_vehicle", nullable = false)
    private String conditionOfVehicle;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "weaponType", cascade = CascadeType.ALL)
    private List<Subdivision> subdivisionList;
}
