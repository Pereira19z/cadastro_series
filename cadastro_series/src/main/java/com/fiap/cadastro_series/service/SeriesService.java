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

    // Listar todas as séries
    public List<Series> listarSeries() {
        return seriesRepository.findAll();
    }

    // Consultar uma série por ID
    public Optional<Series> consultarPorId(Long id) {
        return seriesRepository.findById(id);
    }

    // Adicionar uma nova série
    public Series adicionarSerie(Series serie) {
        return seriesRepository.save(serie);
    }

    // Atualizar uma série existente
    public Series atualizarSerie(Long id, Series serie) {
        // Você pode adicionar lógica para verificar se a série já existe antes de atualizar
        return seriesRepository.save(serie);
    }

    // Remover uma série
    public boolean removerSerie(Long id) {
        if (seriesRepository.existsById(id)) {
            seriesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
