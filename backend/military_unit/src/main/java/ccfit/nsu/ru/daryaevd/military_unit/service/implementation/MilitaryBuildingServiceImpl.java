package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.MilitaryBuildingMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.MilitaryBuildingRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.MilitaryBuildingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class MilitaryBuildingServiceImpl implements MilitaryBuildingService {
     private MilitaryBuildingRepository militaryBuildingRepository;

     private SubdivisionRepository subdivisionRepository;

    public List<MilitaryBuildingDto> getAllMilitaryBuildings() {
        return militaryBuildingRepository.findAll().stream()
                .map(MilitaryBuildingMapper::mapToMilitaryBuildingDto)
                .collect(Collectors.toList());
    }

    public MilitaryBuildingDto getMilitaryBuildingById(Long id) {
        MilitaryBuilding militaryBuilding = militaryBuildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Building not found"));
        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(militaryBuilding);
    }

    public MilitaryBuildingDto createMilitaryBuilding(MilitaryBuildingDto dto) {
        List<Subdivision> subdivisions = subdivisionRepository.findAllById(dto.getSubdivisionIds());
        MilitaryBuilding militaryBuilding = MilitaryBuildingMapper.mapToMilitaryBuilding(dto, subdivisions);
        MilitaryBuilding savedBuilding = militaryBuildingRepository.save(militaryBuilding);
        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(savedBuilding);
    }

    public MilitaryBuildingDto updateMilitaryBuilding(Long id, MilitaryBuildingDto dto) {
        MilitaryBuilding existingBuilding = militaryBuildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Building not found"));

        List<Subdivision> subdivisions = subdivisionRepository.findAllById(dto.getSubdivisionIds());
        existingBuilding.setCanUseForDislocation(dto.getCanUseForDislocation());
        existingBuilding.setTypeOfBuilding(dto.getTypeOfBuilding());
        existingBuilding.setAreaOfBuilding(dto.getAreaOfBuilding());
        existingBuilding.setAmountOfRooms(dto.getAmountOfRooms());
        existingBuilding.setSubdivisions(subdivisions);

        MilitaryBuilding updatedBuilding = militaryBuildingRepository.save(existingBuilding);
        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(updatedBuilding);
    }

    public void deleteMilitaryBuilding(Long id) {
        militaryBuildingRepository.deleteById(id);
    }



    @Override
    public List<MilitaryBuildingDto> getBuildingsBySubdivisionId(Long subdivisionId) {
        List<MilitaryBuilding> buildings = militaryBuildingRepository.findBySubdivisions_Id(subdivisionId);
        return buildings.stream()
                .map(MilitaryBuildingMapper::mapToMilitaryBuildingDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MilitaryBuildingDto> getBuildingsWithMinSubdivisions(int minSubdivisions) {
        List<MilitaryBuilding> buildings = militaryBuildingRepository.findByMinSubdivisions(minSubdivisions);
        return buildings.stream()
                .map(MilitaryBuildingMapper::mapToMilitaryBuildingDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MilitaryBuildingDto> getBuildingsWithNoSubdivisions() {
        List<MilitaryBuilding> buildings = militaryBuildingRepository.findWithNoSubdivisions();
        return buildings.stream()
                .map(MilitaryBuildingMapper::mapToMilitaryBuildingDto)
                .collect(Collectors.toList());
    }


//    public List<MilitaryBuildingDto> getMilitaryBuildingsBySubdivision(Long subdivisionId, Boolean isDislocated) {
//        List<MilitaryBuilding> buildings = militaryBuildingRepository.findBySubdivisionIdAndDislocatedStatus(subdivisionId, isDislocated);
//        return buildings.stream()
//                .map(MilitaryBuildingMapper::mapToMilitaryBuildingDto)
//                .collect(Collectors.toList());
//    }
//
//    public List<MilitaryBuildingDto> getBuildingsWithDislocatedSubdivisions(Boolean isDislocated, int minSubdivisions) {
//        List<MilitaryBuilding> buildings = isDislocated
//                ? militaryBuildingRepository.findBuildingsWithMultipleSubdivisions((long) minSubdivisions)
//                : militaryBuildingRepository.findBuildingsWithNoDislocatedSubdivisions();
//        return buildings.stream()
//                .map(MilitaryBuildingMapper::mapToMilitaryBuildingDto)
//                .collect(Collectors.toList());
//    }

}




//
//public class MilitaryBuildingServiceImpl implements MilitaryBuildingService {
//    private MilitaryBuildingRepository militaryBuildingRepository;
//    @Override
//    public MilitaryBuildingDto createMilitaryBuilding(MilitaryBuildingDto militaryBuildingDto) {
//        MilitaryBuilding militaryBuilding = MilitaryBuildingMapper.mapToMilitaryBuilding(militaryBuildingDto);
//        MilitaryBuilding savedMilitaryBuilding = militaryBuildingRepository.save(militaryBuilding);
//        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(savedMilitaryBuilding);
//    }
//
//    @Override
//    public MilitaryBuildingDto getMilitaryBuildingById(Long militaryBuildingId) {
//        MilitaryBuilding militaryBuilding = militaryBuildingRepository.findById(militaryBuildingId)
//                .orElseThrow(() -> new ResourceNotFoundException("Military building doesn't exist with given id: " + militaryBuildingId));
//        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(militaryBuilding);
//    }
//
//    @Override
//    public List<MilitaryBuildingDto> getAllBuildings() {
//        List<MilitaryBuilding> militaryBuildings = militaryBuildingRepository.findAll();
//        return militaryBuildings.stream().map((militaryBuilding -> MilitaryBuildingMapper.mapToMilitaryBuildingDto(militaryBuilding)))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public MilitaryBuildingDto updateMilitaryBuilding(Long militaryBuildingId, MilitaryBuildingDto updatedMilitaryBuilding) {
//        MilitaryBuilding militaryBuilding = militaryBuildingRepository.findById(militaryBuildingId)
//                .orElseThrow(() -> new ResourceNotFoundException("Military building doesn't exist with given id: " + militaryBuildingId));
//
//        militaryBuilding.setCanUseForDislocation(updatedMilitaryBuilding.getCanUseForDislocation());
//        militaryBuilding.setTypeOfBuilding(updatedMilitaryBuilding.getTypeOfBuilding());
//        militaryBuilding.setAreaOfBuilding(updatedMilitaryBuilding.getAreaOfBuilding());
//        militaryBuilding.setAmountOfRooms(updatedMilitaryBuilding.getAmountOfRooms());
//
//        MilitaryBuilding updatedMilitaryBuildingObj = militaryBuildingRepository.save(militaryBuilding);
//        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(updatedMilitaryBuildingObj);
//    }
//
//    @Override
//    public void deleteMilitaryBuilding(Long militaryBuildingId) {
//        MilitaryBuilding militaryBuilding = militaryBuildingRepository.findById(militaryBuildingId)
//                .orElseThrow(() -> new ResourceNotFoundException("Military building doesn't exist with given id: " + militaryBuildingId));
//        militaryBuildingRepository.deleteById(militaryBuildingId);
//    }
//
//    @Override
//    public List<MilitaryBuilding> getAllMilitaryBuildings() {
//        return militaryBuildingRepository.findAll();
//    }
//
//
////    @Override
////    public List<MilitaryBuilding> findBySubdivisionType(String subdivisionType) {
////        return militaryBuildingRepository.findBySubdivisionType(subdivisionType);
////    }
////
////    @Override
////    public List<MilitaryBuilding> findMilitaryBuildingsWithMultipleDislocatedSubdivisions() {
////        return militaryBuildingRepository.findMilitaryBuildingsWithMultipleDislocatedSubdivisions();
////    }
//}
