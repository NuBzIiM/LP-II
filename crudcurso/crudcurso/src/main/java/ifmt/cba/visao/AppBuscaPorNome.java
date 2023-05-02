package ifmt.cba.visao;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import ifmt.cba.negocio.CursoNegocio;

public class AppBuscaPorNome {
    public static void main(String[] args) {
        try {
            CursoNegocio cursoNegocio = new CursoNegocio();
            String nome = JOptionPane.showInputDialog("Forneca parte do nome do curso a ser localizado");
            ResultSet resultado = cursoNegocio.buscaPorNome(nome);
            while (resultado.next()) {
                System.out.println("Codigo:" + resultado.getInt("codigo"));
                System.out.println("Nome:" + resultado.getString("nome"));
                System.out.println("CargaHoraria:" + resultado.getInt("cargahoraria"));
                System.out.println("NumeroSemestre:" + resultado.getInt("numsemestre"));
                System.out.println("---------------------------------------");
            }
            cursoNegocio.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}