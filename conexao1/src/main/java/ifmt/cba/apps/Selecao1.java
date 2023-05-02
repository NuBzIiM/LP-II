package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ifmt.cba.util.FabricaConexao;

public class Selecao1 {

    public static void main(String args[]) {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("SELECT * FROM grupoproduto ORDER BY nome");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                System.out.println("Codigo:" + resultado.getInt("codigo"));
                System.out.println("Nome:" + resultado.getString("nome"));
                System.out.println("%Promocao:" + resultado.getFloat("promocao"));
                System.out.println("%Margemlucro:" + resultado.getFloat("margemlucro"));
                System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
            }
            resultado.close();
        } catch (Exception ex) {
            System.out.println("Erro ao recuperar os grupos de produtos" + ex.toString());
        } finally {
            try {
                comando.close();
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao desconectar" + ex.toString());
            }
        }
    }
}