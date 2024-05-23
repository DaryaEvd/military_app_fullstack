package ccfit.nsu.ru.daryaevd.military_unit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionDto {
    private Long id;
    private String nameOfSubdivision;
    private Integer numberOfSubdivision;
    private Boolean isDislocated;
    private Long typeOfSubdivision;
}
