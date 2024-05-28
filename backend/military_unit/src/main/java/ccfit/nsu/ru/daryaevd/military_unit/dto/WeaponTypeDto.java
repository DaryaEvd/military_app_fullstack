package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeaponTypeDto {
    private Long id;
    private String nameOfType;
    private Integer experienceOfUsing;
    private String conditionOfWeapon;
    private Long subdivisionId;
    private String type; // Added field to indicate the type of weapon

}
