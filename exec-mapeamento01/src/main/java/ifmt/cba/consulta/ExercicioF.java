package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioF {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT p FROM Pessoa p ORDER BY nome");
            @SuppressWarnings("unchecked")
            List <Pessoa> p = (List <Pessoa>)query.getResultList();

            for(Pessoa p1 : p) {
                System.out.println("Codigo: " + p1.getCodigo() + " Nome: " + p1.getNome());
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
