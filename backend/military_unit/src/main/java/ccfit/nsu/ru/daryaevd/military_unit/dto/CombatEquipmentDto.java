package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CombatEquipmentDto {
    private Long id;
    private String nameOfEquipment;
    private Integer typeOfBuilding;
    private String conditionOfVehicle;
    private Integer numberOfSeats;
    private String nameOfVehicle;
}
