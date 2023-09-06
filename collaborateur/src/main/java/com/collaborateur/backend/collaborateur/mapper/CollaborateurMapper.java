package com.collaborateur.backend.collaborateur.mapper;

import com.collaborateur.backend.collaborateur.Entity.Collaborateur;
import com.collaborateur.backend.collaborateur.dto.CollaborateurDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CollaborateurMapper {

    public CollaborateurDto toDto(Collaborateur collaborateur) {
        CollaborateurDto collaborateurDto = new CollaborateurDto();
        collaborateurDto.setId(collaborateur.getId());
        collaborateurDto.setName(collaborateur.getName());
        collaborateurDto.setJob(collaborateur.getJob());
        collaborateurDto.setImageUrl(collaborateur.getImageUrl());
        return collaborateurDto;
    }

    public Collaborateur toEntity(CollaborateurDto collaborateurDto) {
        Collaborateur collaborateur = new Collaborateur();
        collaborateur.setId(collaborateurDto.getId());
        collaborateur.setName(collaborateurDto.getName());
        collaborateur.setJob(collaborateurDto.getJob());
        collaborateur.setImageUrl(collaborateurDto.getImageUrl());
        return collaborateur;
    }

    public List<CollaborateurDto> toDtoList(List<Collaborateur> collaborateurs) {
        return collaborateurs.stream()
                .map(this::toDto) // Use the toDto method to map each entity
                .toList();
    }

}
