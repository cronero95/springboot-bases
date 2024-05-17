package com.springbootprojects.myfirstproject.villain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("villains")
public class VillainController {

    private final VillainService villainService;

    public VillainController(
        VillainService villainService
    ) {
        this.villainService = villainService;
    }

    @GetMapping()
    public List<VillainResponseDto> findAllVillains() {
        return villainService.findAllVillains();
    }
    
    @GetMapping("id/{villain-id}")
    public VillainResponseDto findVillainById(
        @PathVariable("villain-id") Integer id
    ) {
        return villainService.findVillainById(id);
    }
    
    @PostMapping()
    public VillainResponseDto createVillain(@RequestBody VillainDto villainDto) {
        return villainService.createVillain(villainDto);
    }
    
    @DeleteMapping("id/{villain-id}")
    public String deleteVillainById(
        @PathVariable("villain-id") Integer id
    ) {
        return villainService.deleteVillainById(id);
    }
}
