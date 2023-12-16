package com.example.projetocatalogoimdb.imdb;

import com.example.projetocatalogoimdb.ator.Ator;
import com.example.projetocatalogoimdb.diretor.Diretor;
import com.example.projetocatalogoimdb.filme.Filme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DadosFilmes {

    private List<Filme> filmes;

    public DadosFilmes() {
        this.filmes = new ArrayList<>();
        inicializarFilmes();
    }

    private void inicializarFilmes() {
        adicionarFilme("O Poderoso Chefão", "Descrição 1", "Policial, Drama",
                new Diretor(1, "Francis Ford Coppola"),
                LocalDate.parse("2022-02-24"), 175,
                new Ator("Marlon Brando"), new Ator("Al Pacino"), new Ator("James Caan"));

        adicionarFilme("A Lista de Schindler", "3h 15min", "Drama, Histórico, Biopic",
                new Diretor(2, "Steven Spielberg"),
                LocalDate.parse("2019-05-01"), 195,
                new Ator("Liam Neeson"), new Ator("Ben Kingsley"), new Ator("Ralph Fiennes"));

        adicionarFilme("Um Sonho de Liberdade", "2h 22min", "Drama",
                new Diretor(3, "Frank Darabont"),
                null, 142,
                new Ator("Tim Robbins"), new Ator("Morgan Freeman"), new Ator("Bob Gunton"));

        adicionarFilme("Forrest Gump - O Contador de Histórias", "2h 20min", "Romance, Drama, Comédia",
                new Diretor(4, "Robert Zemeckis"),
                null, 142,
                new Ator("Tom Hanks"), new Ator("Gary Sinise"), new Ator("Robin Wright"));

        adicionarFilme("O Rei Leão", "1h 29min", "Animação, Aventura, Comédia Musical",
                new Diretor(5, "Roger Allers, Rob Minkoff"),
                LocalDate.parse("2011-08-26"), 89,
                new Ator("Garcia Júnior"), new Ator("Matthew Broderick"), new Ator("James Earl Jones"));

        adicionarFilme("O Senhor dos Anéis - O Retorno do Rei", "3h 21min", "Fantasia, Aventura",
                new Diretor(6, "Peter Jackson"),
                null, 201,
                new Ator("Sean Astin"), new Ator("Elijah Wood"), new Ator("Viggo Mortensen"));

        adicionarFilme("À Espera de um Milagre", "3h 09min", "Fantasia, Drama, Policial",
                new Diretor(3, "Frank Darabont"),
                null, 189,
                new Ator("Tom Hanks"), new Ator("Michael Clarke Duncan"), new Ator("David Morse"));

        adicionarFilme("A Vida é Bela", "1h 57min", "Comédia dramática, Drama, Comédia",
                new Diretor(7, "Roberto Benigni"),
                null, 117,
                new Ator("Roberto Benigni"), new Ator("Horst Buchholz"), new Ator("Marisa Paredes"));

        adicionarFilme("Batman - O Cavaleiro Das Trevas", "2h 32min", "Ação, Suspense",
                new Diretor(8, "Christopher Nolan"),
                LocalDate.parse("2019-07-11"), 152,
                new Ator("Christian Bale"), new Ator("Heath Ledger"), new Ator("Aaron Eckhart"));

        adicionarFilme("Vingadores: Ultimato", "3h 01min", "Ação, Aventura, Ficção Científica",
                new Diretor(9, "Joe Russo, Anthony Russo"),
                LocalDate.parse("2019-07-11"), 181,
                new Ator("Robert Downey Jr"), new Ator("Chris Evans"), new Ator("Mark Ruffalo"));
    }

    private void adicionarFilme(String titulo, String descricao, String genero, Diretor diretor,
                                LocalDate dataLancamento, int duracao, Ator... atores) {
        Filme filme = new Filme(titulo, genero, diretor, duracao, Arrays.asList(atores), 0);
        filmes.add(filme);
    }


    public void cadastrarFilmeViaAPI(String titulo, String genero, int duracao, double orcamento) {
        adicionarFilme(titulo, "", genero, null, LocalDate.now(), duracao, new Ator[0]);
        System.out.println("Filme cadastrado com sucesso!");
    }


    public void cadastrarAtor(String nomeAtor) {
        Ator ator = new Ator(nomeAtor);
        // Você pode querer adicionar o ator a uma lista global de atores aqui
        System.out.println("Ator cadastrado com sucesso!");
    }

    public void cadastrarDiretor(String nomeDiretor) {
        Diretor diretor = new Diretor(0, nomeDiretor); // Ajuste o ID conforme necessário
        // Você pode querer adicionar o diretor a uma lista global de diretores aqui
        System.out.println("Diretor cadastrado com sucesso!");
    }

    public void associarAtoresEDiretorFilmeViaAPI(String nomeFilme, String nomeDiretor, String... nomesAtores) {
        Filme filme = buscarFilmePorNome(nomeFilme);
        Diretor diretor = buscarDiretorPorNome(nomeDiretor);

        if (filme != null && diretor != null) {
            List<Ator> atores = Arrays.stream(nomesAtores)
                    .map(Ator::new)
                    .collect(Collectors.toList());

            filme.setDiretor(diretor);
            filme.setAtores(atores);

            System.out.println("Associação realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a associação. Verifique se o filme, diretor ou atores existem.");
        }
    }


    public void pesquisarFilmePorNome(String nomeFilme) {
        Filme filme = buscarFilmePorNome(nomeFilme);

        if (filme != null) {
            System.out.println("Informações do Filme:");
            System.out.println("Nome: " + filme.getTitulo());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Diretor: " + (filme.getDiretor() != null ? filme.getDiretor().getNomeDiretor() : "Não disponível"));
            System.out.println("Duração: " + filme.getDuracao() + " minutos");
            // Adicione outras informações conforme necessário
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    private Filme buscarFilmePorNome(String nomeFilme) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeFilme)) {
                return filme;
            }
        }
        return null;
    }

    private Diretor buscarDiretorPorNome(String nomeDiretor) {
        for (Filme filme : filmes) {
            Diretor diretor = filme.getDiretor();
            if (diretor != null && diretor.getNomeDiretor().equalsIgnoreCase(nomeDiretor)) {
                return diretor;
            }
        }
        return null;
    }


}
