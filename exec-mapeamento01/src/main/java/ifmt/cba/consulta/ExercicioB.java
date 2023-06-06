package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioB {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT f FROM Produto f ORDER BY nome_produto");
            @SuppressWarnings("unchecked")
            List <Produto> p = (List <Produto>)query.getResultList();

            for(Produto p1 : p) {
                System.out.println("Codigo: " + p1.getCodigo_Produto() + " Nome: " + p1.getNome_produto() + 
                " Preco de venda: " + p1.getPreco_venda() + " Grupo Produto: " + p1.getGrupo_produto().getNome());
                
                for(Fornecedor f1 : p1.getFornecedor()) {
                    System.out.println("\tCodigo: " + f1.getCodigo() + " Razao Social: " + f1.getRazaoSocial());
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
