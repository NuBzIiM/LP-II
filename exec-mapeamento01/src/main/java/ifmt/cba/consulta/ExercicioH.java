package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioH {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT p FROM PessoaJuridica p ORDER BY nome");
            @SuppressWarnings("unchecked")
            List <PessoaJuridica> p = (List <PessoaJuridica>)query.getResultList();

            for(PessoaJuridica p1 : p) {
                System.out.println("Codigo: " + p1.getCodigo() + " Nome fantasia: " + p1.getNomeFantasia()
                 + "Razao social: " + p1.getRazaoSocial());
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
