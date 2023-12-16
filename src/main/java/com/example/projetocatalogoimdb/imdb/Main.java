package com.example.projetocatalogoimdb.imdb;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DadosFilmes dadosFilmes = new DadosFilmes();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o título do filme:");
                    String titulo = scanner.nextLine();
                    System.out.println("Informe o gênero do filme:");
                    String genero = scanner.nextLine();
                    System.out.println("Informe a duração do filme em minutos:");
                    int duracao = scanner.nextInt();
                    System.out.println("Informe o orçamento do filme:");
                    double orcamento = scanner.nextDouble();

                    dadosFilmes.cadastrarFilmeViaAPI(titulo, genero, duracao, orcamento);
                    break;
                case 2:
                    System.out.println("Informe o nome do ator:");
                    String nomeAtor = scanner.nextLine();
                    dadosFilmes.cadastrarAtor(nomeAtor);

                    break;
                case 3:
                    System.out.println("Informe o nome do diretor:");
                    String nomeDiretor = scanner.nextLine();
                    dadosFilmes.cadastrarDiretor(nomeDiretor);
                    break;
                case 4:
                    System.out.println("Informe o nome do filme:");
                    String nomeFilme = scanner.nextLine();
                    System.out.println("Informe o nome do diretor:");
                    String nomeDiretorAssociar = scanner.nextLine();
                    System.out.println("Informe os nomes dos atores (separados por vírgula):");
                    String nomesAtores = scanner.nextLine();

                    dadosFilmes.associarAtoresEDiretorFilmeViaAPI(nomeFilme, nomeDiretorAssociar, nomesAtores.split(","));
                    break;
                case 5:
                    System.out.println("Informe o nome do filme para pesquisa:");
                    String nomeFilmePesquisa = scanner.nextLine();
                    dadosFilmes.pesquisarFilmePorNome(nomeFilmePesquisa);
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);
    }

    private static void exibirMenu() {
        System.out.println("\n--- Catálogo de Filmes ---");
        System.out.println("1. Cadastrar filme via API");
        System.out.println("2. Cadastrar ator");
        System.out.println("3. Cadastrar diretor");
        System.out.println("4. Associar atores e diretor a um filme via API");
        System.out.println("5. Pesquisar filme por nome");
        System.out.println("6. Sair");
        System.out.println("Escolha uma opção (1-6):");
    }
}
