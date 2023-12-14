module com.example.projetocatalogoimdb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetocatalogoimdb to javafx.fxml;
    exports com.example.projetocatalogoimdb;
    exports com.example.projetocatalogoimdb.ator;
    opens com.example.projetocatalogoimdb.ator to javafx.fxml;
    exports com.example.projetocatalogoimdb.diretor;
    opens com.example.projetocatalogoimdb.diretor to javafx.fxml;
    exports com.example.projetocatalogoimdb.imdb;
    opens com.example.projetocatalogoimdb.imdb to javafx.fxml;
    exports com.example.projetocatalogoimdb.operacoesfilme;
    opens com.example.projetocatalogoimdb.operacoesfilme to javafx.fxml;
}