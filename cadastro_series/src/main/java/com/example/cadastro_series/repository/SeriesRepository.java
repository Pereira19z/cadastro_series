package com.fiap.cadastro_series.repository;

import com.fiap.cadastro_series.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
