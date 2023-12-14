package com.example.projetocatalogoimdb.operacoesfilme;

import com.example.projetocatalogoimdb.ator.Ator;
import com.example.projetocatalogoimdb.diretor.Diretor;
import com.example.projetocatalogoimdb.filme.Filme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperacoesFilme {

    private List<Filme> listaFilmes;
    private List<Diretor> listaDiretores;  // Certifique-se de ter essa lista
    private List<Ator> listaAtores;  // Certifique-se de ter essa lista

    public OperacoesFilme() {
        this.listaFilmes = new ArrayList<>();
        this.listaDiretores = new ArrayList<>();  // Inicialize a lista de diretores
        this.listaAtores = new ArrayList<>();  // Inicialize a lista de atores
    }

    public void incluirFilme(Filme filme) {
        listaFilmes.add(filme);
    }

    public void incluirAtor(Ator ator) {
        listaAtores.add(ator);
    }

    public void incluirDiretor(Diretor diretor) {
        listaDiretores.add(diretor);
    }

    public boolean associarAtoresDiretorFilme(String nomeFilme, String nomeDiretor, String... nomesAtores) {
        Filme filme = buscarFilmePorNome(nomeFilme);
        Diretor diretor = buscarDiretorPorNome(nomeDiretor);

        if (filme != null && diretor != null && filme.getDiretor().equals(diretor)) {
            Ator[] atores = new Ator[nomesAtores.length];
            for (int i = 0; i < nomesAtores.length; i++) {
                atores[i] = new Ator(nomesAtores[i].trim());
            }

            filme.setDiretor(diretor);
            filme.setAtores(atores);

            System.out.println("Associação realizada com sucesso!");
            return true;
        } else {
            System.out.println("Não foi possível realizar a associação. Verifique se o filme, diretor ou atores existem ou se os nomes estão corretos.");
            return false;
        }
    }




    // Métodos auxiliares para buscar filme, diretor e ator por nome
    private Filme buscarFilmePorNome(String nome) {
        for (Filme filme : listaFilmes) {
            if (filme.getNomeFilme().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    private Diretor buscarDiretorPorNome(String nome) {
        for (Diretor diretor : listaDiretores) {
            if (diretor.getNomeDiretor().equalsIgnoreCase(nome)) {
                return diretor;
            }
        }
        return null;
    }

    private Ator buscarAtorPorNome(String nome) {
        for (Ator ator : listaAtores) {
            if (ator.getNomeAtor().equalsIgnoreCase(nome)) {
                return ator;
            }
        }
        return null;
    }

    public List<Filme> pesquisarFilmePorNome(String nomeFilme) {
        List<Filme> resultados = new ArrayList<>();
        for (Filme filme : listaFilmes) {
            if (filme.getNomeFilme().equalsIgnoreCase(nomeFilme)) {
                resultados.add(filme);
            }
        }
        return resultados;
    }

}