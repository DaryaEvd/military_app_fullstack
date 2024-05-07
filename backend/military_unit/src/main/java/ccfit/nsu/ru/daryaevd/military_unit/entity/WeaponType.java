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
@Table(name = "weapon_type_table")
public class WeaponType {
    /*
     todo: think about it
	weapon_type INT NOT NULL,
    FOREIGN KEY (weapon_type) REFERENCES subdivision_table (id)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_type", nullable = false)
    private String nameOfType;

    @Column(name = "experience_of_using", nullable = false)
    private Integer experienceOfUsing;

    @Column(name = "condition_of_vehicle", nullable = false)
    private String conditionOfVehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivision_id", referencedColumnName = "id")
    private Subdivision subdivision;
}
