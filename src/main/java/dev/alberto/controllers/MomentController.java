package dev.alberto.controllers;

import dev.alberto.dtos.MomentDTO;
import dev.alberto.models.Moment;   
import dev.alberto.mappers.MomentMapper;
import dev.alberto.repositories.MomentRepository;


public class MomentController {

    private MomentRepository repository;

    public MomentController() {
        this.repository = new MomentRepository();
    }

    public void StoreMoment(MomentDTO MomentDTO) {
        Moment momentToSave = MomentMapper.toEntity(MomentDTO);
        repository.StoreMoment(momentToSave);
    }
    
}
