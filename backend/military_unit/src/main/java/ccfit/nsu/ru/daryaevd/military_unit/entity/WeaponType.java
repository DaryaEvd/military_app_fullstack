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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "weapon_type_table")
public abstract class WeaponType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_type", nullable = false)
    private String nameOfType;

    @Column(name = "experience_of_using", nullable = false)
    private Integer experienceOfUsing;

    @Column(name = "condition_of_weapon", nullable = false)
    private String conditionOfWeapon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivision_id", referencedColumnName = "id", nullable = false)
    private Subdivision subdivision;
}
