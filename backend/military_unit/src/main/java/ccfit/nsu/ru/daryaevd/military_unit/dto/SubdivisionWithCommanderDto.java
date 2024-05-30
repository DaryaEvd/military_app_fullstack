package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionWithCommanderDto {
    private Long subdivisionId;
    private String subdivisionName;
    private Long commanderId;
    private String commanderFirstName;
    private String commanderLastName;

}

