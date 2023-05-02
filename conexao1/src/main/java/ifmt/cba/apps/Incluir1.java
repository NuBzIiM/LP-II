package ifmt.cba.apps;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Incluir1 {
    public static void main(String args[]){
        Connection conexao = null;
        Statement comando = null;
        String nome = JOptionPane.showInputDialog("Forneça o nome do grupo de produto");
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto"));
        float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de margem de lucro do grupo de produto"));
        String sql = "INSERT INTO grupoproduto (nome, promocao, margemlucro) VALUES";
        sql += "('" + nome + "', " + promocao + ", " + margem + ")";
        System.out.println(sql);
        try {
            conexao = FabricaConexao.obterConexao();
            comando = conexao.createStatement();
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inclusao realizada com sucesso");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao incluir grupo de produto " + ex);
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
