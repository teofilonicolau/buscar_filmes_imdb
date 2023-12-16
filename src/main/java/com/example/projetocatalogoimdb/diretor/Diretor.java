package com.example.projetocatalogoimdb.diretor;

public class Diretor {
    private int idDiretor;
    private String nomeDiretor;

    public Diretor(int idDiretor, String nomeDiretor) {
        this.idDiretor = idDiretor;
        this.nomeDiretor = nomeDiretor;
    }

    public int getIdDiretor() {
        return idDiretor;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }
}