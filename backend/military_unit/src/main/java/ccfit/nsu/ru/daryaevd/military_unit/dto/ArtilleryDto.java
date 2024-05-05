package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtilleryDto {
    private Long id;
    private String nameArtillery;
    private Integer caliber;
    private Integer firingDistance;
    private Integer shootingSpeed;
    private String typeOfAmmunition;
    private String conditionOfWeapon;
    private Integer experienceOfUsing;

//    private Long subdivisionId;
}
