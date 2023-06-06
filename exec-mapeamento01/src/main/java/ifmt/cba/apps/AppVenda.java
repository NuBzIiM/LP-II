package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;


public class AppVenda {
    public static void main (String args[]){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Venda v;
            
            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
