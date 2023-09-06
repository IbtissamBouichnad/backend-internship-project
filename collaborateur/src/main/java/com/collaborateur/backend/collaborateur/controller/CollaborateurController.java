package com.collaborateur.backend.collaborateur.controller;

import com.collaborateur.backend.collaborateur.dto.CollaborateurDto;
import com.collaborateur.backend.collaborateur.service.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

    private final CollaborateurService collaborateurService;

    @Autowired
    public CollaborateurController(CollaborateurService collaborateurService) {
        this.collaborateurService = collaborateurService;
    }

    @PostMapping("/save")
    public ResponseEntity<CollaborateurDto> createCollaborateur(@RequestBody CollaborateurDto collaborateurDto) {
        CollaborateurDto createdCollaborateur = collaborateurService.createCollaborateur(collaborateurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCollaborateur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollaborateurDto> getCollaborateurById(@PathVariable Long id) {
        CollaborateurDto collaborateur = collaborateurService.getCollaborateurById(id);
        return ResponseEntity.ok(collaborateur);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CollaborateurDto>> getAllCollaborateurs() {
        List<CollaborateurDto> collaborateurs = collaborateurService.getAllCollaborateurs();
        return ResponseEntity.ok(collaborateurs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollaborateurDto> updateCollaborateur(
            @PathVariable Long id,
            @RequestBody CollaborateurDto collaborateurDto
    ) {
        CollaborateurDto updatedCollaborateur = collaborateurService.updateCollaborateur(id, collaborateurDto);
        return ResponseEntity.ok(updatedCollaborateur);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCollaborateur(@PathVariable Long id) {
        collaborateurService.deleteCollaborateur(id);
        return ResponseEntity.noContent().build();
    }
}

