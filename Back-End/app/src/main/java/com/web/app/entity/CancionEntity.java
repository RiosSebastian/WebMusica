package com.web.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Builder
public class CancionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cancionId;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int duracion; // Duración en segundos

    @Column(nullable = false)
    private String genero;



    @ManyToOne
    @JoinColumn(name = "artista_id")
    private ArtistaEntity artista;

    @Column(nullable = false)
    private String urlArchivo; // Ruta o URL del archivo de audio

    @Column(nullable = false)
    private LocalDate fechaSubida;

    public void reproducir() {
        System.out.println("Reproduciendo: " + this.titulo);
    }

    public String obtenerInfo() {
        return String.format("Título: %s, Género: %s, Duración: %d segundos, Artista: %s",
                titulo, genero, duracion, artista != null ? artista.getNombre() : "Desconocido");
    }
}
