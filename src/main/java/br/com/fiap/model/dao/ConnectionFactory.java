package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection abrirConexao() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            String url = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "rm75999";
            String pass = System.getenv("DB_PASS") != null ? System.getenv("DB_PASS") : "150896";

            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexão aberta.");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return con;
    }

    public static void fecharConexao(Connection con) {
        try {
            if(con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar: " + e.getMessage());
        }
    }
}