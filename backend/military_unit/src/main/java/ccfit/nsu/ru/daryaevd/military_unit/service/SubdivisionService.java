package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;

import java.util.List;

public interface SubdivisionService {
    SubdivisionDto createSubdivision(SubdivisionDto subdivisionDto);
    SubdivisionDto getSubdivisionById(Long subdivisionId);
    List<SubdivisionDto> getAllSubdivisions();
    SubdivisionDto updateSubdivision(Long subdivisionId, SubdivisionDto updatedEmployee);
    void deleteSubdivision(Long subdivisionId);
}
