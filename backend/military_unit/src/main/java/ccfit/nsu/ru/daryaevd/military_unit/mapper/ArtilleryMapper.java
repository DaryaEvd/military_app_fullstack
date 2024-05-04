package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.ArtilleryDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;

public class ArtilleryMapper {
    public static ArtilleryDto mapToArtilleryDto(Artillery artillery) {
        ArtilleryDto artilleryDto = new ArtilleryDto();
        artilleryDto.setId(artillery.getId());
        artilleryDto.setNameArtillery(artillery.getNameArtillery());
        artilleryDto.setCaliber(artillery.getCaliber());
        artilleryDto.setFiringDistance(artillery.getFiringDistance());
        artilleryDto.setShootingSpeed(artillery.getShootingSpeed());
        artilleryDto.setTypeOfAmmunition(artillery.getTypeOfAmmunition());
        artilleryDto.setConditionOfWeapon(artillery.getConditionOfWeapon());
        artilleryDto.setExperienceOfUsing(artillery.getExperienceOfUsing());

        artilleryDto.setSubdivisionId(artillery.getSubdivision().getId());

        return artilleryDto;
    }

    public static Artillery mapToArtillery(ArtilleryDto artilleryDto) {
        Artillery artillery = new Artillery();
        artillery.setId(artilleryDto.getId());
        artillery.setNameArtillery(artilleryDto.getNameArtillery());
        artillery.setCaliber(artilleryDto.getCaliber());
        artillery.setFiringDistance(artilleryDto.getFiringDistance());
        artillery.setShootingSpeed(artilleryDto.getShootingSpeed());
        artillery.setTypeOfAmmunition(artilleryDto.getTypeOfAmmunition());
        artillery.setConditionOfWeapon(artilleryDto.getConditionOfWeapon());
        artillery.setExperienceOfUsing(artilleryDto.getExperienceOfUsing());

        Subdivision subdivision = new Subdivision();
        subdivision.setId(artilleryDto.getSubdivisionId());
        artillery.setSubdivision(subdivision);

        return artillery;
    }
}
