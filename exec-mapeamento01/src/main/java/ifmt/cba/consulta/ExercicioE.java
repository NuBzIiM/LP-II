package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioE {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT v FROM Vendedor v ORDER BY nome");
            @SuppressWarnings("unchecked")
            List <Vendedor> v = (List <Vendedor>)query.getResultList();

            for(Vendedor v1 : v) {
                System.out.println("Codigo: " + v1.getCodigo() + " Nome:  " + v1.getNome());
                
                for(Venda ve : v1.getVenda()) {
                    System.out.println("\tCodigo: " + ve.getCodigo_venda() + " Valor da venda: " + ve.getValorVenda() + 
                    " Valor da Comissao: " + v1.getComissao(ve.getValorVenda()));
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
