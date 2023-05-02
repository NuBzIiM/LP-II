package ifmt.cba.execucao;

import java.sql.Connection;

import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class TesteFabrica {
    public static void main(String args[]){
        Connection conexao;
        try {
            conexao = FabricaConexao.obterConexao();
            JOptionPane.showMessageDialog(null, "Conexao estabelecida");
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexao encerrada");
        } catch(Exception sqle) {
            JOptionPane.showMessageDialog(null, "Conexao nao estabelecida - "+sqle.getMessage());
        }
    }
}
