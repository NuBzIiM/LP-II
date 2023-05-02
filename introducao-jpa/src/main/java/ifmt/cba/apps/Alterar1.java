package ifmt.cba.apps;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import javax.swing.JOptionPane;

import ifmt.cba.vo.GrupoProdutoVO;

public class Alterar1 {

    public static void main(String args[]) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVO grupoVO = null;

        try {
            emf = Persistence.createEntityManagerFactory("UnidadeProdutos");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String pNome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto a ser localizado");
            Query consulta = em.createQuery(
                    "SELECT gp FROM GrupoProdutoVO gp WHERE UPPER(gp.nome) = :pNome");

            consulta.setParameter("pNome", pNome.toUpperCase());

            List<GrupoProdutoVO> lista = consulta.getResultList();
            if (lista.size() > 0) {
                grupoVO = lista.get(0);
                String nome = JOptionPane.showInputDialog("Forneca onome do grupo de produto", grupoVO.getNome());
                float margem = Float.parseFloat(JOptionPane.showInputDialog(
                        "Fornecaopercentualdamargemdelucrodogrupodeproduto", grupoVO.getMargemLucro()));
                float promocao = Float.parseFloat(JOptionPane.showInputDialog(
                        "Fornecaopercentualdepromocaodogrupodeproduto", grupoVO.getPromocao()));
                grupoVO.setNome(nome);
                grupoVO.setMargemLucro(margem);
                grupoVO.setPromocao(promocao);
                em.merge(grupoVO);
                em.getTransaction().commit();
                System.out.println("Alteracaorealizadacomsucesso");
            } else {
                System.out.println("GrupodeProdutonaolocalizado");
            }
        } catch (Exception ex) {
            System.out.println("Alteracaonaorealizada−" + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}