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
    private String weaponCategory;
    private Integer experienceOfUsing;
    private String conditionOfWeapon;
    private Long subdivisionId;

    // Параметры для Gun
    private String nameOfGun;
    private Integer shootingSpeed;
    private Integer caliber;
    private Integer magazineCapacity;

    // Параметры для Artillery
    private String nameArtillery;
    private Integer firingDistance;
    private String typeOfAmmunition;

    // Параметры для RocketWeapon
    private Integer flightRangeOfRocket;
    private String typeOfMissileGuidance;

}



//public class WeaponTypeDto {
//    private Long id;
//    private String nameOfType;
//    private Integer experienceOfUsing;
//    private String conditionOfWeapon;
//    private Long subdivisionId;
//    private String type; // Added field to indicate the type of weapon
//
//}
