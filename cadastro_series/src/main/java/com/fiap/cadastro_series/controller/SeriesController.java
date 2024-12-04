package com.fiap.cadastro_series.controller;

import com.fiap.cadastro_series.model.Series;  // Certifique-se de que a importação está correta
import com.fiap.cadastro_series.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    // Listar todas as séries
    @GetMapping
    public ResponseEntity<List<Series>> listarSeries() {
        List<Series> series = seriesService.listarSeries();
        return ResponseEntity.ok(series);
    }

    // Consultar uma série por ID
    @GetMapping("/{id}")
    public ResponseEntity<Series> consultarPorId(@PathVariable Long id) {
        Optional<Series> serie = seriesService.consultarPorId(id);
        if (serie.isPresent()) {
            return ResponseEntity.ok(serie.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Adicionar uma nova série
    @PostMapping
    public ResponseEntity<Series> adicionarSerie(@RequestBody Series serie) {
        Series novaSerie = seriesService.adicionarSerie(serie);
        return ResponseEntity.ok(novaSerie);
    }

    // Atualizar uma série existente
    @PutMapping("/{id}")
    public ResponseEntity<Series> atualizarSerie(@PathVariable Long id, @RequestBody Series serie) {
        Series serieAtualizada = seriesService.atualizarSerie(id, serie);
        return ResponseEntity.ok(serieAtualizada);
    }

    // Remover uma série
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerSerie(@PathVariable Long id) {
        if (seriesService.removerSerie(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
