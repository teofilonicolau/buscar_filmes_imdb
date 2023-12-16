package com.example.projetocatalogoimdb.imdb;

import com.example.projetocatalogoimdb.ator.Ator;
import com.example.projetocatalogoimdb.diretor.Diretor;
import com.example.projetocatalogoimdb.filme.Filme;
import com.example.projetocatalogoimdb.operacoesfilme.OperacoesFilme;

import java.time.LocalDate;
import java.util.List;


import java.util.ArrayList;


public class IMDB {

    private List<Filme> filmes;

    public IMDB() {
        this.filmes = new ArrayList<>();
        inicializarFilmes();
    }

    public void adicionarFilme(Filme filme) {
        this.filmes.add(filme);
    }

    private void inicializarFilmes() {

    }

    public List<Filme> getFilmes() {
        return filmes;
    }
}
