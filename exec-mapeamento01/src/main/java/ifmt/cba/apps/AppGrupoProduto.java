package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import jakarta.persistence.EntityManager;



public class AppGrupoProduto {
    
    public static void main (String args[]){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            GrupoProduto gp;
            em.getTransaction().begin();

            gp = new GrupoProduto("Bebidas");
            em.persist(gp);

            gp = new GrupoProduto("Carnes");
            em.persist(gp);

            gp = new GrupoProduto("Padaria");
            em.persist(gp);
           
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
