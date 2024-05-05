package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RocketWeaponDto {
    private Long id;
    private Integer flightRangeOfRocket;
    private String typeOfMissileGuidance;
    private String typeOfAmmunition;
    private String conditionOfWeapon;
    private Integer experienceOfUsing;

    private Long weaponTypeId;
}
