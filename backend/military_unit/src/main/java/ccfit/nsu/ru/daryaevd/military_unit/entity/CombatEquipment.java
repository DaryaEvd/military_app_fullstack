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
@Table(name = "combat_equipment_table")
public class CombatEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_equipment", nullable = false)
    private String nameOfEquipment;

    @Column(name = "experience_of_using", nullable = false)
    private Integer experienceOfUsing;

    @Column(name = "condition_of_vehicle", nullable = false)
    private String conditionOfVehicle;

    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @Column(name = "name_of_vehicle", nullable = false)
    private String nameOfVehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivision_id", referencedColumnName = "id")
    private Subdivision subdivision;
}
