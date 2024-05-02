package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MilitaryBuildingDto {
    private Long id;

    private Boolean canUseForDislocation;

    private Integer typeOfBuilding;

    private Boolean areaOfBuilding;

    private Integer amountOfRooms;
}
