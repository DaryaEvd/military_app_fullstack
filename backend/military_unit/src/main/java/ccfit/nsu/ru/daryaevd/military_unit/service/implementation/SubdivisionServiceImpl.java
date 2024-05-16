package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.SubdivisionMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubdivisionServiceImpl implements SubdivisionService {

    private SubdivisionRepository subdivisionRepository;

    @Override
    public SubdivisionDto createSubdivision(SubdivisionDto subdivisionDto) {
        Subdivision subdivision = SubdivisionMapper.mapToSubdivision(subdivisionDto);
        Subdivision savedSubdivision = subdivisionRepository.save(subdivision);
        return SubdivisionMapper.mapToSubdivisionDto(savedSubdivision);
    }

    @Override
    public SubdivisionDto getSubdivisionById(Long subdivisionId) {
        Subdivision subdivision = subdivisionRepository.findById(subdivisionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + subdivisionId));
        return SubdivisionMapper.mapToSubdivisionDto(subdivision);
    }

    @Override
    public List<SubdivisionDto> getAllSubdivisions() {
        List<Subdivision> subdivisions = subdivisionRepository.findAll();
        return subdivisions.stream().map((subdivision -> SubdivisionMapper.mapToSubdivisionDto(subdivision)))
                .collect(Collectors.toList());
    }

    @Override
    public SubdivisionDto updateSubdivision(Long subdivisionId, SubdivisionDto updatedSubdivision) {

        Subdivision subdivision = subdivisionRepository.findById(subdivisionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + subdivisionId));

        subdivision.setNameOfSubdivision(updatedSubdivision.getNameOfSubdivision());
        subdivision.setNumberOfSubdivision(updatedSubdivision.getNumberOfSubdivision());
        subdivision.setIsDislocated(updatedSubdivision.getIsDislocated());

//        subdivision.setCommander(updatedSubdivision.getCommander());

        // Create a new SubdivisionType object and set its ID
        SubdivisionType subdivisionType = new SubdivisionType();
        subdivisionType.setId(updatedSubdivision.getTypeOfSubdivision());
        subdivision.setTypeOfSubdivision(subdivisionType);

        Subdivision updatedSubdivisionObj = subdivisionRepository.save(subdivision);

        return SubdivisionMapper.mapToSubdivisionDto(updatedSubdivisionObj);
    }

    @Override
    public void deleteSubdivision(Long subdivisionId) {
        Subdivision subdivision = subdivisionRepository.findById(subdivisionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + subdivisionId)
        );
        subdivisionRepository.deleteById(subdivisionId);
    }


    @Override
    public List<Object[]> findSubdivisionsWithMostMilitaryUnits() {
        return subdivisionRepository.findSubdivisionsWithMostMilitaryUnits();
    }

    @Override
    public List<Object[]> findCommanderBySubdivisionName(String subdivisionName) {
        return subdivisionRepository.findCommanderBySubdivisionName(subdivisionName);
    }

    @Override
    public List<Subdivision> findSubdivisionsWithSpecifiedCombatEquipment() {
        return subdivisionRepository.findSubdivisionsWithSpecifiedCombatEquipment();
    }


//    public List<Object[]> findOfficersByRank(Integer rank) {
//        return subdivisionRepository.findOfficersByRank(rank);
//    }

}
