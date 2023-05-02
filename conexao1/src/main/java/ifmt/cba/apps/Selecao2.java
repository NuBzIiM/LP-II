package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Selecao2 {

    public static void main(String args[]) {
        Connection conexao = null;
        PreparedStatement comando = null;
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo a ser pesquisado"));
        try {
            conexao =  FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("SELECT * FROM grupoproduto WHERE codigo=?");
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                System.out.println("Encontrado:" + resultado.getString("nome"));
            } else {
                System.out.println("Naoencontrado");
            }
        } catch (Exception ex) {
            System.out.println("Erroaorecuperarumgrupo" + ex.toString());
        } finally {
            try {
                comando.close();
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erroaodesconectar" + ex.toString());
            }
        }
    }
}