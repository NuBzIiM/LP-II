package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Incluir3 {
    public static void main(String args[]) {
        Connection conexao = null;
        PreparedStatement comando = null;
        String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto");
        float promocao = Float
                .parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto"));
        float margem = Float
                .parseFloat(JOptionPane.showInputDialog("Forneca o percentual da margem de lucro do grupo de produto"));
        try {
            conexao = FabricaConexao.obterConexao();
            String sql = "INSERT INTO grupoproduto ( nome, promocao, margemlucro) VALUES ( ? , ? , ? )";
            comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, nome);
            comando.setFloat(2, promocao);
            comando.setFloat(3, margem);
            comando.executeUpdate();
            ResultSet rs = comando.getGeneratedKeys();
            long chave = 0;
            if (rs.next()) {
                chave = rs.getLong("codigo");
            }
            System.out.println("Inclusaorealizadacomsucesso[chave:" + chave + "]");
        } catch (Exception ex) {
            System.out.println("Erroaoincluirgrupodeproduto" + ex.toString());
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