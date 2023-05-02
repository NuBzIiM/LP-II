package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Incluir2 {

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
            comando = conexao.prepareStatement("INSERT INTO grupoproduto ( nome , promocao , margemlucro ) VALUES( ? ,? , ? )");
            comando.setString(1, nome);
            comando.setFloat(2, promocao);
            comando.setFloat(3, margem);
            comando.executeUpdate();
            JOptionPane.showMessageDialog(null,"Inclusao realizada com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao incluir grupo de produto" + ex.toString());
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