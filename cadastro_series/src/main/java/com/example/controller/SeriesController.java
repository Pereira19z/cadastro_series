package com.fiap.cadastro_series.controller;

import com.fiap.cadastro_series.model.Series;
import com.fiap.cadastro_series.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping
    public List<Series> listarSeries() {
        return seriesService.listarSeries();
    }

    @GetMapping("/{id}")
    public Optional<Series> consultarPorId(@PathVariable Long id) {
        return seriesService.consultarPorId(id);
    }

    @PostMapping
    public Series adicionarSerie(@RequestBody Series serie) {
        return seriesService.adicionarSerie(serie);
    }

    @PutMapping("/{id}")
    public Series atualizarSerie(@PathVariable Long id, @RequestBody Series serie) {
        return seriesService.atualizarSerie(id, serie);
    }

    @DeleteMapping("/{id}")
    public boolean removerSerie(@PathVariable Long id) {
        return seriesService.removerSerie(id);
    }
}
