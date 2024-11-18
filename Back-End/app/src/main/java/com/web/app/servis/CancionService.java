package com.web.app.servis;

import com.web.app.entity.ArtistaEntity;
import com.web.app.entity.CancionEntity;
import com.web.app.repository.ArtistaRepository;
import com.web.app.repository.CancionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CancionService {

    private final CancionRepository cancionRepository;
    private final ArtistaRepository artistaRepository;

    // Ruta base donde se almacenarán los archivos (para almacenamiento local)
    private static final String UPLOAD_DIR = "uploads/canciones/";

    public CancionEntity subirCancion(String titulo, int duracion, String genero, Long artistaId, MultipartFile archivo) throws IOException {

        // Verificar si el artista existe
        ArtistaEntity artista = artistaId != null ? artistaRepository.findById(artistaId)
                .orElseThrow(() -> new NoSuchElementException("Artista no encontrado")) : null;

        // Guardar el archivo físicamente
        String nombreArchivo = guardarArchivo(archivo);

        // Crear y guardar la entidad Cancion
        CancionEntity cancion = CancionEntity.builder()
                .titulo(titulo)
                .duracion(duracion)
                .genero(genero)
                .artista(artista)
                .urlArchivo(UPLOAD_DIR + nombreArchivo)
                .fechaSubida(LocalDate.now())
                .build();

        return cancionRepository.save(cancion);
    }

    private String guardarArchivo(MultipartFile archivo) throws IOException {
        // Crear directorio si no existe
        File directorio = new File(UPLOAD_DIR);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        // Guardar el archivo
        String nombreArchivo = UUID.randomUUID() + "_" + archivo.getOriginalFilename();
        File archivoDestino = new File(directorio, nombreArchivo);
        archivo.transferTo(archivoDestino);

        return nombreArchivo;
    }

    public List<CancionEntity> buscarPorGenero(String genero) {
        return cancionRepository.findByGenero(genero);
    }

    public CancionEntity obtenerPorId(Long id) {
        return cancionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Canción no encontrada"));
    }
}
