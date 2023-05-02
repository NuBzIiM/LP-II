package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ifmt.cba.util.FabricaConexao;

public class Selecao5 {

    private static Connection conexao;
    private static PreparedStatement comandoSelecaoGrupo;

    static {

        try {
            conexao = FabricaConexao.obterConexao();
            comandoSelecaoGrupo = conexao.prepareStatement("SELECT * FROM grupoprodut WHERE codigo=? ");
        } catch (Exception ex) {
            System.out.println("Erro ao preparar consulta de grupos" + ex.toString());
        }
    }

    public static void main(String args[]) {
        PreparedStatement comandoSelecaoProduto = null;
        try {
            comandoSelecaoProduto = conexao.prepareStatement("SELECT * FROM produto ORDER BY nome");
            ResultSet resultado = comandoSelecaoProduto.executeQuery();
            while (resultado.next()) {
                System.out.println("Codigo..........:" + resultado.getInt("codigo"));
                System.out.println("Nome............:" + resultado.getString("nome"));
                System.out.println("Estoque.........:" + resultado.getInt("estoque"));
                System.out.println("ValorCompra....:" + resultado.getFloat("valorcompra"));
                System.out.println("%Promocao......:" + resultado.getFloat("promocao"));
                System.out.println("%Margemlucro..:" + resultado.getFloat("margemlucro"));
                System.out.println("Grupo...........:" + obterNomeGrupoProduto(resultado.getInt("grupo")));
                System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar os produtos" + ex.toString());
        } finally {
            try {
                comandoSelecaoProduto.close();
                comandoSelecaoGrupo.close();
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao desconectar" + ex.toString());
            }
        }
    }

    public static String obterNomeGrupoProduto(int codigo) {
        String nomeGrupo = null;

        try {
            comandoSelecaoGrupo.setInt(1, codigo);
            ResultSet resultado = comandoSelecaoGrupo.executeQuery();
            if (resultado.next()) {
                nomeGrupo = resultado.getString("nome");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar um grupo" + ex.toString());
        }
        return nomeGrupo;
    }
}