package Jdbc.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    //Define a conexão com o Postgres
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    /*Indica qual usário será utlizado para conectar ao banco.
    Esse usuário deverá ser igual ao configurado no banco de dados*/
    private static final String user = "postgres";
    //Senha do usuário
    private final static String password = "1234";
    //Objeto que fará a conexão com o banco
    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(url, user, password);
                ;
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null || !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close database connection");
            throw new RuntimeException(e);
        }
    }

}
