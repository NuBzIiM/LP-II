package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioA {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT f FROM Fornecedor f ORDER BY razaoSocial");
            @SuppressWarnings("unchecked")
            List <Fornecedor> f = (List <Fornecedor>)query.getResultList();

            for(Fornecedor f1 : f) {
                System.out.println("Codigo: " + f1.getCodigo() + " Nome: " + f1.getNome());
                for(Produto p1 : f1.getProduto()) {
                    System.out.println("\tCodigo: " + p1.getCodigo_Produto() + " Nome: " + p1.getNome_produto());
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
