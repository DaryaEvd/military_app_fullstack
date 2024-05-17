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
@Table(name = "gun_table")
public class Gun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_gun", nullable = false)
    private String nameOfGun;

    @Column(name = "shooting_speed", nullable = false)
    private Integer shootingSpeed;

    @Column(name = "caliber", nullable = false)
    private Integer caliber;

    @Column(name = "magazine_capacity", nullable = false)
    private Integer magazineCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id", referencedColumnName = "id")
    private WeaponType weaponType;
}
