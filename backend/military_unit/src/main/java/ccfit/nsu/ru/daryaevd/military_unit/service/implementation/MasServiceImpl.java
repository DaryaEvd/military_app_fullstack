package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MasDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.MasMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.MasRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.MasService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MasServiceImpl implements MasService {

    @Autowired
    private final MasRepository masRepository;

    @Override
    public MasDto createMas(MasDto masDto) {
        Mas mas = MasMapper.mapToMas(masDto);
        Mas savedMas = masRepository.save(mas);
        return MasMapper.mapToMasDto(savedMas);
    }

    @Override
    public MasDto getMasById(Long masId) {
        Mas mas = masRepository.findById(masId)
                .orElseThrow(() -> new ResourceNotFoundException("MAS type doesn't exist with given id: " + masId));
        return MasMapper.mapToMasDto(mas);
    }

    @Override
    public List<MasDto> getAllMas() {
        List<Mas> masList = masRepository.findAll();
        return masList.stream().map(MasMapper::mapToMasDto).collect(Collectors.toList());
    }

    @Override
    public MasDto updateMas(Long masId, MasDto updatedMas) {
        Mas mas = masRepository.findById(masId)
                .orElseThrow(() -> new ResourceNotFoundException("MAS type doesn't exist with given id: " + masId));

        mas.setNameOfMas(updatedMas.getNameOfMas());
        mas.setCodeOfMas(updatedMas.getCodeOfMas());

        Mas updatedMasObj = masRepository.save(mas);
        return MasMapper.mapToMasDto(updatedMasObj);
    }

    @Override
    public void deleteMas(Long masId) {
        if (!masRepository.existsById(masId)) {
            throw new ResourceNotFoundException("MAS type doesn't exist with given id: " + masId);
        }
        masRepository.deleteById(masId);
    }

//    @Override
//    public List<String> findMasWithMoreThanFiveSoldiersOrNone() {
//        return masRepository.findMasWithMoreThanFiveSoldiersOrNone();
//    }
}
