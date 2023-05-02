package ifmt.cba.visao;

import javax.swing.JOptionPane;

import ifmt.cba.negocio.CursoNegocio;

public class AppInclusao {
    public static void main(String[] args) {

        try {
            CursoNegocio cursoNegocio = new CursoNegocio();

            String nome = JOptionPane.showInputDialog("Forneca o nome do curso");
            int cargahoraria = Integer.parseInt(JOptionPane.showInputDialog("Forneca a carga horaria do curso"));
            int numsemestre = Integer.parseInt(JOptionPane.showInputDialog("Forneca o novo numero de semestres do curso"));

            cursoNegocio.incluir(nome, cargahoraria, numsemestre);
            cursoNegocio.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
