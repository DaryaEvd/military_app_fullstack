package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;

import java.util.List;

public interface SubdivisionTypeService {
    SubdivisionTypeDto createSubdivisionType(SubdivisionTypeDto subdivisionTypeDto);
    SubdivisionTypeDto getSubdivisionTypeById(Long subdivisionTypeId);
    List<SubdivisionTypeDto> getAllSubdivisionTypes();
    SubdivisionTypeDto updateSubdivisionType(Long subdivisionTypeId, SubdivisionTypeDto updatedSubdivisionType);
    void deleteSubdivisionType(Long subdivisionTypeId);
}
