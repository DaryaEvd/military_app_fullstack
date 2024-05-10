package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionTypeDto {
    private Long id;
    private String nameOfType;
    private Integer subdivisionRank;

    private Long subdivisionType;
}
