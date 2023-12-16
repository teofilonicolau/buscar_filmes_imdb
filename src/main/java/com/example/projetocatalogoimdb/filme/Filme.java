// Classe Filme
package com.example.projetocatalogoimdb.filme;

import com.example.projetocatalogoimdb.diretor.Diretor;
import com.example.projetocatalogoimdb.ator.Ator;

import java.util.List;

public class Filme {
    private String titulo;
    private String genero; // Adicionado o atributo genero
    private int duracao;
    private List<Ator> atores;
    private Diretor diretor;
    private double orcamento;


    public Filme(String titulo, String genero, Diretor diretor, int duracao, List<Ator> atores, double orcamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
        this.duracao = duracao;
        this.atores = atores;
        this.orcamento = orcamento;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", diretor=" + diretor +
                ", duracao=" + duracao +
                ", atores=" + atores +
                ", orcamento=" + orcamento +
                '}';
    }
}
