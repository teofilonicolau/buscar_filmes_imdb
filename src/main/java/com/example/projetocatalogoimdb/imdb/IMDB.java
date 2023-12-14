package com.example.projetocatalogoimdb.imdb;

import com.example.projetocatalogoimdb.ator.Ator;
import com.example.projetocatalogoimdb.diretor.Diretor;
import com.example.projetocatalogoimdb.filme.Filme;
import com.example.projetocatalogoimdb.operacoesfilme.OperacoesFilme;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IMDB {

    private static OperacoesFilme operacoesFilme = new OperacoesFilme();

    public static void main(String[] args) {
        System.out.println("Projeto inicial para um sistema de IMDB");
        processaEntrada();
    }

    private static void processaEntrada() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirOpcoes();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    cadastrarAtor();
                    break;
                case 3:
                    cadastrarDiretor();
                    break;
                case 4:
                    associarAtoresEDiretor();
                    break;
                case 5:
                    pesquisarFilmePorNome();
                    break;
                case 6:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private static void exibirOpcoes() {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Cadastrar filme");
        System.out.println("2. Cadastrar ator");
        System.out.println("3. Cadastrar diretor");
        System.out.println("4. Associar atores e diretor a um filme");
        System.out.println("5. Pesquisar filme por nome");
        System.out.println("6. Sair");
    }

    private static void cadastrarFilme() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do filme:");
        String nomeFilme = scanner.nextLine();

        // Criar uma instância de Filme apenas com o nome e deixar outros campos como nulos/inicializados
        Filme novoFilme = new Filme(nomeFilme, null, null, null, null, 0, null);

        // Utilize operacoesFilme para chamar o método de inclusão
        operacoesFilme.incluirFilme(novoFilme);

        System.out.println("Filme foi salvo com sucesso.");
    }

    private static void cadastrarAtor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do ator:");
        String nomeAtor = scanner.nextLine();

        // Crie uma instância de Ator com as informações coletadas
        Ator novoAtor = new Ator(nomeAtor);

        // Utilize operacoesFilme para chamar o método de inclusão
        operacoesFilme.incluirAtor(novoAtor);

        System.out.println("Ator foi salvo com sucesso.");
    }

    private static void cadastrarDiretor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do diretor:");
        String nomeDiretor = scanner.nextLine();

        // Crie uma instância de Diretor com as informações coletadas
        Diretor novoDiretor = new Diretor(nomeDiretor);

        // Utilize operacoesFilme para chamar o método de inclusão
        operacoesFilme.incluirDiretor(novoDiretor);

        System.out.println("Diretor foi salvo com sucesso.");
    }

    private static void associarAtoresEDiretor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do filme para associar:");
        String nomeFilme = scanner.nextLine();

        System.out.println("Digite o nome do diretor:");
        String nomeDiretor = scanner.nextLine();

        System.out.println("Digite o nome do ator:");
        String nomeAtor = scanner.nextLine();

        // Utilize operacoesFilme para chamar o método de associação
        boolean associacaoBemSucedida = operacoesFilme.associarAtoresDiretorFilme(nomeFilme, nomeDiretor, nomeAtor);

        if (associacaoBemSucedida) {
            System.out.println("Associação realizada com sucesso.");
        } else {
            System.out.println("Não foi possível realizar a associação. Verifique se os nomes estão corretos ou se o filme, diretor ou ator existem.");
        }
    }

    private static void pesquisarFilmePorNome() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do filme para pesquisa:");
        String nomePesquisa = scanner.nextLine();

        // Utilize operacoesFilme para obter a lista de filmes
        List<Filme> listaFilmes = operacoesFilme.pesquisarFilmePorNome(nomePesquisa);

        // Verifique se há resultados
        if (!listaFilmes.isEmpty()) {
            // Itere sobre a lista para exibir os resultados da pesquisa
            for (Filme filme : listaFilmes) {
                System.out.println("Nome: " + filme.getNomeFilme());
                System.out.println("Diretor: " + (filme.getDiretor() != null ? filme.getDiretor().getNomeDiretor() : "N/A"));

                Ator[] atores = filme.getAtores();
                System.out.print("Atores: ");

                if (atores != null && atores.length > 0) {
                    for (int i = 0; i < atores.length - 1; i++) {
                        System.out.print(atores[i].getNomeAtor() + ", ");
                    }
                    System.out.println(atores[atores.length - 1].getNomeAtor());
                } else {
                    System.out.println("N/A");
                }

                // Adicione outros atributos conforme necessário
                System.out.println("----------");
            }
        } else {
            System.out.println("Nenhum filme encontrado com o nome especificado.");
        }
    }


}
