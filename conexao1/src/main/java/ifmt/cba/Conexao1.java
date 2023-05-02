package ifmt.cba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao1 {
    public static void main(String[] args){
        Connection conexao;
        String url = "jdbc:postgresql://localhost:5432/produtos";
        String usr = "postgres";
        String pass = "postgre";
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexao estabelecida");
            conexao.close();
            System.out.println("Conexao encerrada");    
        } catch (ClassNotFoundException cnf){
            System.out.println("Classe do driver nao encontrado - "+cnf.getMessage());
        } catch (SQLException sqle) {
            System.out.println("Conexao nao estabelecida - "+sqle.getMessage());
        }
    }
}
