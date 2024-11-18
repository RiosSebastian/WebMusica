package com.web.app.controllers;

import com.web.app.entity.CancionEntity;
import com.web.app.servis.CancionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/canciones")
@RequiredArgsConstructor
public class CancionController {

    private final CancionService cancionService;

    @PostMapping("/subir")
    public ResponseEntity<CancionEntity> subirCancion(
            @RequestParam String titulo,
            @RequestParam int duracion,
            @RequestParam String genero,
            @RequestParam(required = false) Long artistaId,
            @RequestPart MultipartFile archivo) throws IOException {

        CancionEntity cancion = cancionService.subirCancion(titulo, duracion, genero, artistaId, archivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(cancion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CancionEntity> obtenerCancion(@PathVariable Long id) {
        CancionEntity cancion = cancionService.obtenerPorId(id);
        return ResponseEntity.ok(cancion);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CancionEntity>> buscarPorGenero(@RequestParam String genero) {
        List<CancionEntity> canciones = cancionService.buscarPorGenero(genero);
        return ResponseEntity.ok(canciones);
    }
}

