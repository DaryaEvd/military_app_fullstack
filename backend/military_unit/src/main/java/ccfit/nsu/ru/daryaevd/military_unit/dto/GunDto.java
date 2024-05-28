package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GunDto extends WeaponTypeDto {
    private String nameOfGun;
    private Integer shootingSpeed;
    private Integer caliber;
    private Integer magazineCapacity;

}
