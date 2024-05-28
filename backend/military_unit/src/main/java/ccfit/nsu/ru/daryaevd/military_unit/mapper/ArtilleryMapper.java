package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.ArtilleryDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

import java.util.List;
import java.util.stream.Collectors;

public class ArtilleryMapper {
    public static ArtilleryDto mapToArtilleryDto(Artillery artillery) {
        ArtilleryDto dto = new ArtilleryDto();
        dto.setId(artillery.getId());
        dto.setExperienceOfUsing(artillery.getExperienceOfUsing());
        dto.setConditionOfWeapon(artillery.getConditionOfWeapon());
        dto.setSubdivisionId(artillery.getSubdivision().getId());
        dto.setNameArtillery(artillery.getNameArtillery());
        dto.setCaliber(artillery.getCaliber());
        dto.setFiringDistance(artillery.getFiringDistance());
        dto.setShootingSpeed(artillery.getShootingSpeed());
        dto.setTypeOfAmmunition(artillery.getTypeOfAmmunition());
        dto.setWeaponCategory("Artillery");
        return dto;
    }

    public static Artillery mapToArtillery(ArtilleryDto dto) {
        Artillery artillery = new Artillery();
        artillery.setId(dto.getId());
         artillery.setExperienceOfUsing(dto.getExperienceOfUsing());
        artillery.setConditionOfWeapon(dto.getConditionOfWeapon());
        // Subdivision should be set separately
        artillery.setNameArtillery(dto.getNameArtillery());
        artillery.setCaliber(dto.getCaliber());
        artillery.setFiringDistance(dto.getFiringDistance());
        artillery.setShootingSpeed(dto.getShootingSpeed());
        artillery.setTypeOfAmmunition(dto.getTypeOfAmmunition());
        return artillery;
    }

    public static List<ArtilleryDto> toDtoList(List<Artillery> artilleryList) {
        return artilleryList.stream().map(ArtilleryMapper::mapToArtilleryDto).collect(Collectors.toList());
    }
}
