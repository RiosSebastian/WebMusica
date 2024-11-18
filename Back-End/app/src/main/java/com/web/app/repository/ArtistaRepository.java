package com.web.app.repository;

import com.web.app.entity.ArtistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<ArtistaEntity, Long> {
    Optional<ArtistaEntity> findByNombre(String nombre);

}
