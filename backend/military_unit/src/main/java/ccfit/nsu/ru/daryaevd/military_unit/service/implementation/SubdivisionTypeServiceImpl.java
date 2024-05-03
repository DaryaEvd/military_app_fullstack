package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.SubdivisionTypeMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionTypeRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubdivisionTypeServiceImpl implements SubdivisionTypeService {

    private final SubdivisionTypeRepository subdivisionTypeRepository;

    @Override
    public SubdivisionTypeDto createSubdivisionType(SubdivisionTypeDto subdivisionTypeDto) {
        SubdivisionType subdivisionType = SubdivisionTypeMapper.mapToSubdivisionType(subdivisionTypeDto);
        SubdivisionType savedSubdivisionType = subdivisionTypeRepository.save(subdivisionType);
        return SubdivisionTypeMapper.mapToSubdivisionTypeDto(savedSubdivisionType);
    }

    @Override
    public SubdivisionTypeDto getSubdivisionTypeById(Long subdivisionTypeId) {
        SubdivisionType subdivisionType = subdivisionTypeRepository.findById(subdivisionTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision Type doesn't exist with given id: " + subdivisionTypeId));
        return SubdivisionTypeMapper.mapToSubdivisionTypeDto(subdivisionType);
    }

    @Override
    public List<SubdivisionTypeDto> getAllSubdivisionTypes() {
        List<SubdivisionType> subdivisionTypes = subdivisionTypeRepository.findAll();
        return subdivisionTypes.stream().map(SubdivisionTypeMapper::mapToSubdivisionTypeDto).collect(Collectors.toList());
    }

    @Override
    public SubdivisionTypeDto updateSubdivisionType(Long subdivisionTypeId, SubdivisionTypeDto updatedSubdivisionType) {
        SubdivisionType subdivisionType = subdivisionTypeRepository.findById(subdivisionTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision Type doesn't exist with given id: " + subdivisionTypeId));

        subdivisionType.setNameOfType(updatedSubdivisionType.getNameOfType());
        subdivisionType.setSubdivisionRank(updatedSubdivisionType.getSubdivisionRank());

        SubdivisionType updatedSubdivisionTypeObj = subdivisionTypeRepository.save(subdivisionType);
        return SubdivisionTypeMapper.mapToSubdivisionTypeDto(updatedSubdivisionTypeObj);
    }

    @Override
    public void deleteSubdivisionType(Long subdivisionTypeId) {
        if (!subdivisionTypeRepository.existsById(subdivisionTypeId)) {
            throw new ResourceNotFoundException("Subdivision Type doesn't exist with given id: " + subdivisionTypeId);
        }
        subdivisionTypeRepository.deleteById(subdivisionTypeId);
    }
}