package com.fiap.cadastro_series.controller;

import com.fiap.cadastro_series.model.Series;
import com.fiap.cadastro_series.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    // Listar todas as séries com paginação (se necessário)
    @GetMapping
    public ResponseEntity<List<Series>> listarSeries() {
        List<Series> seriesList = seriesService.listarSeries();
        if (seriesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content se não houver séries
        }
        return new ResponseEntity<>(seriesList, HttpStatus.OK); // 200 OK
    }

    // Consultar uma série específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<Series> consultarPorId(@PathVariable Long id) {
        Optional<Series> serie = seriesService.consultarPorId(id);
        if (serie.isPresent()) {
            return new ResponseEntity<>(serie.get(), HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found se não encontrar
        }
    }

    // Adicionar uma nova série
    @PostMapping
    public ResponseEntity<Series> adicionarSerie(@RequestBody Series serie) {
        try {
            Series novaSerie = seriesService.adicionarSerie(serie);
            return new ResponseEntity<>(novaSerie, HttpStatus.CREATED); // 201 Created
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request em caso de erro
        }
    }

    // Atualizar os dados de uma série existente
    @PutMapping("/{id}")
    public ResponseEntity<Series> atualizarSerie(@PathVariable Long id, @RequestBody Series serie) {
        Optional<Series> serieExistente = seriesService.consultarPorId(id);
        if (serieExistente.isPresent()) {
            seriesService.atualizarSerie(id, serie);
            return new ResponseEntity<>(serie, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found se não encontrar a série
        }
    }

    // Remover uma série
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerSerie(@PathVariable Long id) {
        Optional<Series> serieExistente = seriesService.consultarPorId(id);
        if (serieExistente.isPresent()) {
            seriesService.removerSerie(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content se removido com sucesso
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found se a série não for encontrada
        }
    }
}
