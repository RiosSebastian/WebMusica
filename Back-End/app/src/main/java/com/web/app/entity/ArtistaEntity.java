package com.web.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
public class ArtistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistaId;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column
    private String biografia;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CancionEntity> canciones = new ArrayList<>();


}
