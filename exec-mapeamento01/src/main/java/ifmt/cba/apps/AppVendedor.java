package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;

public class AppVendedor {
    
    public static void main (String args[]){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Vendedor vendedor = new Vendedor("Julio", "321", "32", 10);
            em.persist(vendedor);

            vendedor = new Vendedor("Joyce", "654", "65", 11);
            em.persist(vendedor);

            vendedor = new Vendedor("Elizeu", "987", "98", 9);
            em.persist(vendedor);

            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
