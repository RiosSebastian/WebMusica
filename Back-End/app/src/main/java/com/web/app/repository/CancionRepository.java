package com.web.app.repository;

import com.web.app.entity.CancionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancionRepository extends JpaRepository<CancionEntity, Long> {
    List<CancionEntity> findByGenero(String genero);
    List<CancionEntity> findByTituloContainingIgnoreCase(String titulo);
}
