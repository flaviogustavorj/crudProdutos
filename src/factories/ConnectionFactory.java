package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    //Metodo para retornar a conexão com o banco e dados
    public static Connection getConnection() throws Exception {
        var host = "jdbc:postgresql://localhost:5432/dbprodutos";
        var user = "postgres";
        var password = "coti";
        return DriverManager.getConnection(host, user, password);
    }
}
