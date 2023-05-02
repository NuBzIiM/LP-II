package ifmt.cba.visao;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import ifmt.cba.negocio.CursoNegocio;

public class AppExclusao {

    public static void main(String[] args) {
        try {
            CursoNegocio cursoNegocio = new CursoNegocio();
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo do curso a ser Excluido"));
            ResultSet resultado = cursoNegocio.buscaPorCodigo(codigo);
            if (resultado.next()) {
                cursoNegocio.excluir(resultado.getInt("codigo"));
            } else {
                JOptionPane.showMessageDialog(null, "Nao localizado");
            }
            cursoNegocio.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
