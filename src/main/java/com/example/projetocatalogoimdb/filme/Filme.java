package com.example.projetocatalogoimdb.filme;

import com.example.projetocatalogoimdb.ator.Ator;
import com.example.projetocatalogoimdb.diretor.Diretor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class Filme {
    private String nomeFilme;
    private String descricaoFilme;
    private String genero;
    private Diretor diretor;
    private LocalDate dataLancamento;
    private double orcamento;
    private Ator[] atores;
    private String duracao;

    // Construtor corrigido
    public Filme(String nomeFilme, String descricaoFilme, String genero, Diretor diretor, LocalDate dataLancamento, double orcamento, Ator[] atores) {
        this.nomeFilme = nomeFilme;
        this.descricaoFilme = descricaoFilme;
        this.genero = genero;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.atores = atores;
    }

    // Getters

    public String getNomeFilme() {
        return this.nomeFilme;
    }

    // Getter para o gênero
    public String getGenero() {
        return this.genero;
    }
    public Diretor getDiretor() {
        return this.diretor;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }

    public double getOrcamento() {
        return this.orcamento;
    }

    public String getDescricaoFilme() {
        return this.descricaoFilme;
    }

    public Ator[] getAtores() {
        return this.atores;
    }

    // Setter para Atores
    public void setAtores(Ator[] atores) {
        this.atores = atores;
    }

    // Setter para Diretor
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    // Método toString personalizado
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nomeFilme).append("\n");
        sb.append("Descrição: ").append(descricaoFilme).append("\n");
        sb.append("Gênero: ").append(genero).append("\n");
        sb.append("Diretor: ").append(diretor != null ? diretor.getNomeDiretor() : "N/A").append("\n");
        sb.append("Data de Lançamento: ").append(dataLancamento != null ? dataLancamento.toString() : "N/A").append("\n");
        sb.append("Orçamento: ").append(orcamento).append("\n");
        sb.append("Atores: ").append(Arrays.toString(atores)).append("\n");
        return sb.toString();
    }

    public String getDuracao() {
        return this.duracao != null ? this.duracao : "Não disponível";
    }
    public boolean atorParticipou(String nomeAtor) {
        if (atores != null) {
            for (Ator ator : atores) {
                if (ator.getNomeAtor().equalsIgnoreCase(nomeAtor)) {
                    return true;
                }
            }
        }
        return false;
    }
}