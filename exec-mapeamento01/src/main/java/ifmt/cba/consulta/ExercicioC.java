package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioC {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT c FROM Cliente c ORDER BY nome");
            @SuppressWarnings("unchecked")
            List <Cliente> c = (List <Cliente>)query.getResultList();

            for(Cliente c1 : c) {
                System.out.println("Codigo: " + c1.getCodigo() + " Nome: " + c1.getNome() + " Numero de compras: " +
                c1.getVenda().size());
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
