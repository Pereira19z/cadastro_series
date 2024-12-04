package com.fiap.cadastro_series.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Series {

    @Id
    private Long id;

    @NotEmpty(message = "Nome da série é obrigatório")
    private String nome;

    @NotEmpty(message = "Gênero é obrigatório")
    private String genero;

    @NotNull(message = "Ano de lançamento é obrigatório")
    @Min(value = 1900, message = "Ano de lançamento inválido")
    private int anoLancamento;

    @Min(value = 1, message = "A quantidade de temporadas deve ser positiva")
    private int quantidadeTemporadas;

    @NotEmpty(message = "Classificação indicativa é obrigatória")
    private String classificacao;

    // Getters and Setters

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

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getQuantidadeTemporadas() {
        return quantidadeTemporadas;
    }

    public void setQuantidadeTemporadas(int quantidadeTemporadas) {
        this.quantidadeTemporadas = quantidadeTemporadas;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
