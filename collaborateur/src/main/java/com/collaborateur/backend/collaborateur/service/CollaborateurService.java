package com.collaborateur.backend.collaborateur.service;

import com.collaborateur.backend.collaborateur.dto.CollaborateurDto;

import java.util.List;

public interface CollaborateurService {
    CollaborateurDto createCollaborateur(CollaborateurDto collaborateurDto);

    CollaborateurDto getCollaborateurById(Long id);

    List<CollaborateurDto> getAllCollaborateurs();

    CollaborateurDto updateCollaborateur(Long id, CollaborateurDto collaborateurDto);

    void deleteCollaborateur(Long id);
}
