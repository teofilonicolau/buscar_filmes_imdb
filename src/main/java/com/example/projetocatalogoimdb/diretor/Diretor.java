package com.example.projetocatalogoimdb.diretor;

public class Diretor {
    private String nomeDiretor;

    // Adicione o modificador de acesso public ao construtor
    public Diretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getNomeDiretor() {
        return this.nomeDiretor;
    }

    public String getDescricaoDiretor() {
        return this.getDescricaoDiretor();
    }
}
