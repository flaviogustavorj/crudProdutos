package repositories;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {
    public void create(Produto produto) throws Exception {

        try (var connection = ConnectionFactory.getConnection()){

            var statement = connection.prepareStatement("INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)");

            //Passando os valores da query sql para gravar os produtos no banco de dados
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());

            statement.execute();
        };

    }
}
