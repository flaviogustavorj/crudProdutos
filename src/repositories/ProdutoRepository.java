package repositories;

import entities.Produto;
import factories.ConnectionFactory;

import java.sql.Statement;

public class ProdutoRepository {
    public Integer create(Produto produto) throws Exception {

        try (var connection = ConnectionFactory.getConnection()){

            var statement = connection.prepareStatement(
                    "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            //Passando os valores da query sql para gravar os produtos no banco de dados
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());

            statement.execute();

            //Retorna o id do produto cadastrado
            var keys = statement.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
            else {
                throw new Exception("Não foi possível obter o id do produto cadastrado.");
            }
        }
    }

    public boolean update(Produto produto) throws Exception {

        try (var connection = ConnectionFactory.getConnection()){

            var statement = connection.prepareStatement("UPDATE produtos SET nome = ?, preco = ?, quantidade = ? WHERE id = ?");

            //Passando os valores da query sql para atualizar os produtos no banco de dados
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setInt(4, produto.getId());

            return statement.executeUpdate() > 0;
        }
    }

    //Método para excluir um produto do banco de dados
    public boolean delete(Integer id) throws Exception {

        try (var connection = ConnectionFactory.getConnection()) {

            var statement = connection.prepareStatement("DELETE FROM produtos WHERE id = ?");

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        }
    }

    //Método para consultar os produtos no banco de dados
    public void findAll() throws Exception {

        // Abrir conexão com o banco de dados
        try (var connection = ConnectionFactory.getConnection()) {

            //Escrever uma sentença para consultar os produtos no banco de dados
            var statement = connection.prepareStatement("SELECT * FROM produtos ORDER BY id");

            var data = statement.executeQuery();

            while (data.next()) {
                System.out.println("ID.............: " + data.getInt("id"));
                System.out.println("Nome...........: " + data.getString("nome"));
                System.out.println("Preço..........: " + data.getDouble("preco"));
                System.out.println("Quantidade.....: " + data.getInt("quantidade"));
                System.out.println("Data e hora....: " + data.getTimestamp("datahoracadastro"));
                System.out.println("-----------------------------------");
            }
        }
    }
}
