package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MasDto;

import java.util.List;

public interface MasService {
    MasDto createMas(MasDto masDto);

    MasDto getMasById(Long masId);

    List<MasDto> getAllMas();

    MasDto updateMas(Long masId, MasDto updatedMas);

    void deleteMas(Long masId);

    List<String> findMasWithMoreThanFiveSoldiersOrNone();
}
