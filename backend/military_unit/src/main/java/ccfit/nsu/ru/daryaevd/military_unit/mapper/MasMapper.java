package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MasDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;



public class MasMapper {

//    @Autowired
//    private ModelMapper modelMapper;

    public static MasDto mapToMasDto(Mas mas) {
        MasDto masDto = new MasDto();
        masDto.setId(mas.getId());
        masDto.setNameOfMas(mas.getNameOfMas());
        masDto.setCodeOfMas(mas.getCodeOfMas());

        return masDto;
    }

    public static Mas mapToMas(MasDto masDto) {
        Mas mas = new Mas();
        mas.setId(masDto.getId());
        mas.setNameOfMas(masDto.getNameOfMas());
        mas.setCodeOfMas(masDto.getCodeOfMas());
        return mas;
    }
}