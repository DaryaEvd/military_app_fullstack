package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rocket_weapon_table")
public class RocketWeapon {
/*
TODO: think about it
	name_rocket_weapon TEXT NOT NULL,
	FOREIGN KEY(name_rocket_weapon) REFERENCES weapon_type_table(id)
 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_range_of_rocket", nullable = false)
    private Integer flightRangeOfRocket;

    @Column(name = "type_of_missile_guidance", nullable = false)
    private String typeOfMissileGuidance;

    @Column(name = "type_of_ammunition", nullable = false)
    private String typeOfAmmunition;

    @Column(name = "condition_of_weapon", nullable = false)
    private String conditionOfWeapon;
    @Column(name = "experience_of_using", nullable = false)
    private Integer experienceOfUsing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id", referencedColumnName = "id")
    private WeaponType weaponType;
}
