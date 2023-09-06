package com.collaborateur.backend.collaborateur.service.Impl;
import com.collaborateur.backend.collaborateur.Entity.Collaborateur;
import com.collaborateur.backend.collaborateur.dto.CollaborateurDto;
import com.collaborateur.backend.collaborateur.mapper.CollaborateurMapper;
import com.collaborateur.backend.collaborateur.repository.CollaborateurRepository;
import com.collaborateur.backend.collaborateur.service.CollaborateurService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborateurServiceImpl implements CollaborateurService {

    private final CollaborateurRepository collaborateurRepository;
    private final CollaborateurMapper collaborateurMapper;

    @Autowired
    public CollaborateurServiceImpl(
            CollaborateurRepository collaborateurRepository,
            CollaborateurMapper collaborateurMapper
    ) {
        this.collaborateurRepository = collaborateurRepository;
        this.collaborateurMapper = collaborateurMapper;
    }

    @Override
    public CollaborateurDto createCollaborateur(CollaborateurDto collaborateurDto) {
        // Convert CollaborateurDto to Collaborateur entity
        Collaborateur collaborateur = collaborateurMapper.toEntity(collaborateurDto);

        // Save the entity in the database
        Collaborateur savedCollaborateur = collaborateurRepository.save(collaborateur);

        // Convert the saved entity back to CollaborateurDto and return it
        return collaborateurMapper.toDto(savedCollaborateur);
    }

    @Override
    public CollaborateurDto getCollaborateurById(Long id) {
        // Retrieve the Collaborateur entity by ID from the database
        Collaborateur collaborateur = collaborateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collaborateur not found with id: " + id));

        // Convert the entity to CollaborateurDto and return it
        return collaborateurMapper.toDto(collaborateur);
    }

    @Override
    public List<CollaborateurDto> getAllCollaborateurs() {
        // Retrieve all Collaborateur entities from the database
        List<Collaborateur> collaborateurs = collaborateurRepository.findAll();

        // Convert the list of entities to a list of CollaborateurDto objects and return it
        return collaborateurMapper.toDtoList(collaborateurs);
    }

    @Override
    public CollaborateurDto updateCollaborateur(Long id, CollaborateurDto collaborateurDto) {
        // Retrieve the Collaborateur entity by ID from the database
        Collaborateur existingCollaborateur = collaborateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collaborateur not found with id: " + id));

        // Update the entity with the data from the DTO
        existingCollaborateur.setName(collaborateurDto.getName());
        existingCollaborateur.setJob(collaborateurDto.getJob());
        existingCollaborateur.setImageUrl(collaborateurDto.getImageUrl());

        // Save the updated entity in the database
        Collaborateur updatedCollaborateur = collaborateurRepository.save(existingCollaborateur);

        // Convert the updated entity back to CollaborateurDto and return it
        return collaborateurMapper.toDto(updatedCollaborateur);
    }

    @Override
    public void deleteCollaborateur(Long id) {
        // Check if the Collaborateur exists
        if (!collaborateurRepository.existsById(id)) {
            throw new ResourceNotFoundException("Collaborateur not found with id: " + id);
        }

        // Delete the Collaborateur by ID from the database
        collaborateurRepository.deleteById(id);
    }
}
