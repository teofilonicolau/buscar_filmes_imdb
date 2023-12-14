package com.example.projetocatalogoimdb.imdb;

import com.example.projetocatalogoimdb.ator.Ator;
import com.example.projetocatalogoimdb.diretor.Diretor;
import com.example.projetocatalogoimdb.filme.Filme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DadosFilmes {

    private List<Filme> filmes;

    public DadosFilmes() {
        this.filmes = new ArrayList<>();
        inicializarFilmes();
    }

    private void adicionarFilme(String nome, String duracao, String genero, String relancamento, String diretor, String... elenco) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", Locale.forLanguageTag("pt-BR"));

        Filme filme = new Filme(nome, null, genero, new Diretor(diretor),
                relancamento.isEmpty() ? null : LocalDate.parse(relancamento, formatter), 0, null);

        Ator[] atores = new Ator[elenco.length];
        for (int i = 0; i < elenco.length; i++) {
            atores[i] = new Ator(elenco[i].trim());
        }
        filme.setAtores(atores);

        filmes.add(filme);
    }

    private void inicializarFilmes() {
        adicionarFilme("O Poderoso Chefão", "2h 55min", "Policial, Drama", "24 de fevereiro de 2022", "Francis Ford Coppola", "Marlon Brando", "Al Pacino", "James Caan");
        adicionarFilme("A Lista de Schindler", "3h 15min", "Drama, Histórico, Biopic", "1 de maio de 2019", "Steven Spielberg", "Liam Neeson", "Ben Kingsley", "Ralph Fiennes");
        adicionarFilme("Um Sonho de Liberdade", "2h 22min", "Drama", "", "Frank Darabont", "Tim Robbins", "Morgan Freeman", "Bob Gunton");
        adicionarFilme("Forrest Gump - O Contador de Histórias", "2h 20min", "Romance, Drama, Comédia", "", "Robert Zemeckis", "Tom Hanks", "Gary Sinise", "Robin Wright");
        adicionarFilme("O Rei Leão", "1h 29min", "Animação, Aventura,Comédia Musical", "26 de agosto de 2011", "Roger Allers, Rob Minkoff", "Garcia Júnior", "Matthew Broderick", "James Earl Jones");
        adicionarFilme("O Senhor dos Anéis - O Retorno do Rei", "3h 21min", "Fantasia, Aventura", "", "Peter Jackson", "Sean Astin", "Elijah Wood", "Viggo Mortensen");
        adicionarFilme("À Espera de um Milagre", "3h 09min", "Fantasia, Drama, Policial", "Frank Darabont",  "Tom Hanks", "Michael Clarke Duncan", "David Morse");
        adicionarFilme("A Vida é Bela", "1h 57min", "Comédia dramática, Drama, Comédia", "Roberto Benigni",  "Roberto Benigni", "Horst Buchholz", "Marisa Paredes");
        adicionarFilme("Batman - O Cavaleiro Das Trevas", "2h 32min", "Ação, Suspense", "11 de julho de 2019", "Christopher Nolan", "Christian Bale", "Heath Ledger", "Aaron Eckhart");
        adicionarFilme("Vingadores: Ultimato", "3h 01min", "Ação, Aventura, Ficção Científica", "11 de julho de 2019", "Joe Russo", "Anthony Russo", "Robert Downey Jr", "Chris Evans", "Mark Ruffalo");
    }

    public void associarAtoresEDiretorFilme(String nomeFilme, String nomeDiretor, String... nomesAtores) {
        Filme filme = buscarFilmePorNome(nomeFilme);
        Diretor diretor = buscarDiretorPorNome(nomeDiretor);

        if (filme != null && diretor != null) {
            Ator[] atores = new Ator[nomesAtores.length];
            for (int i = 0; i < nomesAtores.length; i++) {
                atores[i] = new Ator(nomesAtores[i].trim());
            }

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
            System.out.println("Nome: " + filme.getNomeFilme());
            System.out.println("Descrição: " + filme.getDescricaoFilme());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Diretor: " + (filme.getDiretor() != null ? filme.getDiretor().getNomeDiretor() : "Não disponível"));
            System.out.println("Data de Lançamento: " + (filme.getDataLancamento() != null ? filme.getDataLancamento().format(DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", Locale.forLanguageTag("pt-BR"))) : "Não disponível"));
            System.out.println("Duração: " + (filme.getDuracao() != null ? filme.getDuracao() : "Não disponível"));
            System.out.println("Atores:");

            for (Ator ator : filme.getAtores()) {
                System.out.println("- " + ator.getNomeAtor());
            }
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    public void pesquisarDiretorPorNome(String nomeDiretor) {
        Diretor diretor = buscarDiretorPorNome(nomeDiretor);

        if (diretor != null) {
            System.out.println("Informações do Diretor:");
            System.out.println("Nome: " + diretor.getNomeDiretor());
            System.out.println("Descrição: " + diretor.getDescricaoDiretor());
        } else {
            System.out.println("Diretor não encontrado.");
        }
    }

    private Filme buscarFilmePorNome(String nomeFilme) {
        for (Filme filme : filmes) {
            if (filme.getNomeFilme().equalsIgnoreCase(nomeFilme)) {
                return filme;
            }
        }
        return null; // Retorna null se o filme não for encontrado
    }

    private Diretor buscarDiretorPorNome(String nomeDiretor) {
        for (Filme filme : filmes) {
            Diretor diretor = filme.getDiretor();
            if (diretor != null && diretor.getNomeDiretor().equalsIgnoreCase(nomeDiretor)) {
                return diretor;
            }
        }
        return null; // Retorna null se o diretor não for encontrado
    }

    public static void main(String[] args) {
        DadosFilmes dadosFilmes = new DadosFilmes();
        Scanner scanner = new Scanner(System.in);

        // Exemplo de pesquisa de filme por nome
        System.out.println("Digite o nome do filme para pesquisa:");
        String nomeFilmePesquisa = scanner.nextLine();
        dadosFilmes.pesquisarFilmePorNome(nomeFilmePesquisa);

        // Exemplo de pesquisa de diretor por nome
        System.out.println("Digite o nome do diretor para pesquisa:");
        String nomeDiretorPesquisa = scanner.nextLine();
        dadosFilmes.pesquisarDiretorPorNome(nomeDiretorPesquisa);

        // Exemplo de associação de atores e diretor a um filme
        System.out.println("Digite o nome do filme para associar atores e diretor:");
        String nomeFilmeAssociar = scanner.nextLine();
        System.out.println("Digite o nome do diretor para associação:");
        String nomeDiretorAssociar = scanner.nextLine();
        System.out.println("Digite os nomes dos atores para associação (separados por vírgula):");
        String nomesAtoresAssociar = scanner.nextLine();
        String[] arrayNomesAtores = nomesAtoresAssociar.split(",");
        dadosFilmes.associarAtoresEDiretorFilme(nomeFilmeAssociar, nomeDiretorAssociar, arrayNomesAtores);
    }
}
