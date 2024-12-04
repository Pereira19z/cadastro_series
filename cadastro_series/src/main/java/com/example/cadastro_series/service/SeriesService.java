package com.fiap.cadastro_series.service;

import com.fiap.cadastro_series.model.Series;
import com.fiap.cadastro_series.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> listarSeries() {
        return seriesRepository.findAll();
    }

    public Optional<Series> consultarPorId(Long id) {
        return seriesRepository.findById(id);
    }

    public Series adicionarSerie(Series serie) {
        return seriesRepository.save(serie);
    }

    public Series atualizarSerie(Long id, Series serie) {
        if (seriesRepository.existsById(id)) {
            serie.setId(id);
            return seriesRepository.save(serie);
        }
        return null;
    }

    public boolean removerSerie(Long id) {
        if (seriesRepository.existsById(id)) {
            seriesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
