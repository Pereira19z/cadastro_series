package com.fiap.cadastro_series.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera IDs automaticamente
    private Long id;

    @NotEmpty(message = "Nome da série é obrigatório")
    private String nome;

    @NotEmpty(message = "Gênero é obrigatório")
    private String genero;

    @NotNull(message = "Ano de lançamento é obrigatório")
    @Min(value = 1900, message = "Ano de lançamento inválido")
    private Integer anoLancamento; // Usar Integer para permitir validações

    @NotNull(message = "Quantidade de temporadas é obrigatória")
    @Min(value = 1, message = "A quantidade de temporadas deve ser positiva")
    private Integer quantidadeTemporadas; // Usar Integer para permitir validações

    @NotEmpty(message = "Classificação indicativa é obrigatória")
    private String classificacao;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getQuantidadeTemporadas() {
        return quantidadeTemporadas;
    }

    public void setQuantidadeTemporadas(Integer quantidadeTemporadas) {
        this.quantidadeTemporadas = quantidadeTemporadas;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
