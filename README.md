# Projeto Catálogo IMDb

## Descrição do Projeto

O projeto Catálogo IMDb é um sistema simplificado para gerenciar informações sobre filmes, diretores e atores. Ele permite cadastrar filmes, atores e diretores, associar atores e diretor a um filme específico e pesquisar filmes por nome.

## Estrutura do Projeto

O projeto está organizado em diferentes pacotes:

- **com.example.projetocatalogoimdb.ator**: Contém a classe `Ator`, que representa um ator de cinema.

- **com.example.projetocatalogoimdb.diretor**: Contém a classe `Diretor`, que representa um diretor de cinema.

- **com.example.projetocatalogoimdb.filme**: Contém a classe `Filme`, que representa um filme. Esta classe inclui informações como nome, descrição, gênero, diretor, data de lançamento, orçamento, atores, entre outros.

- **com.example.projetocatalogoimdb.imdb**: Contém as classes principais do sistema. A classe `DadosFilmes` inicializa alguns filmes de exemplo e fornece métodos para associar atores e diretor a um filme, além de pesquisar informações sobre filmes e diretores. A classe `IMDB` é a classe principal do sistema, que interage com o usuário por meio de um menu.

- **com.example.projetocatalogoimdb.operacoesfilme**: Contém a classe `OperacoesFilme`, que fornece métodos para incluir filmes, atores e diretores, além de associar atores e diretor a um filme.

## Funcionalidades

1. **Cadastrar Filme**: Permite ao usuário cadastrar informações sobre um novo filme, incluindo nome, descrição, gênero, diretor, data de lançamento, orçamento e atores.

2. **Cadastrar Ator**: Permite ao usuário cadastrar informações sobre um novo ator, incluindo apenas o nome.

3. **Cadastrar Diretor**: Permite ao usuário cadastrar informações sobre um novo diretor, incluindo apenas o nome.

4. **Associar Atores e Diretor a um Filme**: Permite associar atores e um diretor a um filme existente.

5. **Pesquisar Filme por Nome**: Permite ao usuário pesquisar informações sobre um filme específico, incluindo detalhes sobre o diretor, atores e outros atributos.

6. **Sair**: Encerra o programa.

## Como Executar

Para executar o programa, siga os passos:

1. Compile todos os arquivos fonte do projeto.
2. Execute a classe `IMDB` para iniciar o programa.

## Exemplo de Uso

Ao iniciar o programa, você verá um menu com opções numeradas. Selecione a opção desejada digitando o número correspondente e siga as instruções na tela.

## Notas Finais

Este projeto é uma versão simplificada e didática de um sistema de catálogo IMDb. 
Modificações e melhorias podem ser feitas para torná-lo mais robusto e adequado às necessidades específicas.
(Ainda não conseguimos fazer funcionar as opções:4. Associar atores e diretor a um filme e 
5. Pesquisar filme por nome,aceitamos sua contribuição)
)
## Sugestões e Contribuições

Este é um projeto em constante evolução, e sugestões são bem-vindas. Sinta-se à vontade para contribuir, propor melhorias ou reportar problemas. Aceitamos contribuições na forma de pull requests.
