package com.springbootprojects.myfirstproject.villain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class VillainService {

    private final VillainRepository villainRepository;
    private final VillainMapper villainMapper;

    public VillainService(
        VillainRepository villainRepository,
        VillainMapper villainMapper
    ) {
        this.villainRepository = villainRepository;
        this.villainMapper = villainMapper;
    }

    public List<VillainResponseDto> findAllVillains() {
        return villainRepository.findAll()
            .stream()
            .map(villainMapper::villainToDtoResponse)
            .collect(Collectors.toList());
    }

    public VillainResponseDto findVillainById(Integer id) {
        return villainRepository.findById(id)
            .map(villainMapper::villainToDtoResponse)
            .orElse(null);
    }

    public VillainResponseDto createVillain(VillainDto villainDto) {
        var villain = villainMapper.dtoToVillain(villainDto);
        villainRepository.save(villain);
        return villainMapper.villainToDtoResponse(villain);
    }

    public String deleteVillainById(Integer id) {
        villainRepository.deleteById(id);
        return "The villain with id: "+id+" was deleted";
    }
}
