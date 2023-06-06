package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


public class AppProduto {
    public static void main (String args[]){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Produto a = new Produto("Coca", 5);
            Query query = em.createQuery("SELECT g FROM GrupoProduto g WHERE nome = 'Bebidas'");
            GrupoProduto gp = (GrupoProduto)query.getSingleResult();
            a.setGrupo_produto(gp);
            em.persist(a);
            
            a = new Produto("Picanha", 15);
            query = em.createQuery("SELECT g FROM GrupoProduto g WHERE nome = 'Carnes'");
            gp = (GrupoProduto)query.getSingleResult();
            a.setGrupo_produto(gp);
            em.persist(a);

            a = new Produto("Pao de alho", 3);
            query = em.createQuery("SELECT g FROM GrupoProduto g WHERE nome = 'Padaria'");
            gp = (GrupoProduto)query.getSingleResult();
            a.setGrupo_produto(gp);
            em.persist(a);

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
