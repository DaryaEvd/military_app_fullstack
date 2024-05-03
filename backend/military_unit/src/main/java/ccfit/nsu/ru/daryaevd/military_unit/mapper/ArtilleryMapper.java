package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.ArtilleryDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;

public class ArtilleryMapper {
    public static ArtilleryDto mapToArtilleryDto(Artillery artillery) {
        return new ArtilleryDto(
                artillery.getId(),
                artillery.getNameArtillery(),
                artillery.getCaliber(),
                artillery.getFiringDistance(),
                artillery.getShootingSpeed(),
                artillery.getTypeOfAmmunition(),
                artillery.getConditionOfWeapon(),
                artillery.getExperienceOfUsing()
        );
    }

    public static Artillery mapToArtillery(ArtilleryDto artilleryDto) {
        return new Artillery(
                artilleryDto.getId(),
                artilleryDto.getNameArtillery(),
                artilleryDto.getCaliber(),
                artilleryDto.getFiringDistance(),
                artilleryDto.getShootingSpeed(),
                artilleryDto.getTypeOfAmmunition(),
                artilleryDto.getConditionOfWeapon(),
                artilleryDto.getExperienceOfUsing()
        );
    }
}
