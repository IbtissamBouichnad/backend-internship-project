package com.collaborateur.backend.collaborateur.repository;

import com.collaborateur.backend.collaborateur.Entity.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CollaborateurRepository extends JpaRepository<Collaborateur,Long> {
}
