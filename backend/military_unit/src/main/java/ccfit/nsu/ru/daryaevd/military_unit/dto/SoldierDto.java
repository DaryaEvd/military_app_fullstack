package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldierDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String militaryCard;
    private Date dateOfIssueMilitaryCard;
    private Long masId;
    private Long typeOfSoldier;
    private Long subdivisionId;
    private Boolean isCommander;
}
