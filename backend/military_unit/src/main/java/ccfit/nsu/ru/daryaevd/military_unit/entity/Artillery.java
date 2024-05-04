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
@Table(name = "artillery_table")
public class Artillery {
    /**
     TODO: think about this

     name_artillery TEXT NOT NULL,
     FOREIGN KEY(name_artillery) REFERENCES weapon_type_table(id)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_artillery", nullable = false)
    private String nameArtillery;

    @Column(name = "caliber", nullable = false)
    private Integer caliber;

    @Column(name = "firing_distance", nullable = false)
    private Integer firingDistance;

    @Column(name = "shooting_speed", nullable = false)
    private Integer shootingSpeed;

    @Column(name = "type_of_ammunition", nullable = false)
    private String typeOfAmmunition;

    @Column(name = "condition_of_weapon", nullable = false)
    private String conditionOfWeapon;

    @Column(name = "experience_of_using", nullable = false)
    private Integer experienceOfUsing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivision_id", referencedColumnName = "id")
    private Subdivision subdivision;
}
