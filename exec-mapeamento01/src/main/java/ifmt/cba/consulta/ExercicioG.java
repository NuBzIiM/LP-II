package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaFisica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioG {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT p FROM PessoaFisica p ORDER BY nome");
            @SuppressWarnings("unchecked")
            List <PessoaFisica> p = (List <PessoaFisica>)query.getResultList();

            for(PessoaFisica p1 : p) {
                System.out.println("Codigo: " + p1.getCodigo() + " Nome: " + p1.getNome() + 
                " RG: " + p1.getRg() + " CPF: " + p1.getCpf());
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
