package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RocketWeaponDto extends WeaponTypeDto {
    private Integer flightRangeOfRocket;
    private String typeOfMissileGuidance;
    private String typeOfAmmunition;
}
