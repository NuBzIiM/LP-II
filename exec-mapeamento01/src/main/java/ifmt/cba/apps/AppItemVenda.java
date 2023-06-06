package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;

public class AppItemVenda {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Produto p;
            em.getTransaction().begin();

            ItemVenda iv = new ItemVenda(5, 4, 0);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome_produto = 'Coca'").getSingleResult();
            iv.setProduto(p);
            em.persist(iv);

            iv = new ItemVenda(10, 30, 10);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome_produto = 'Pao de alho'").getSingleResult();
            iv.setProduto(p);
            em.persist(iv);

            iv = new ItemVenda(3, 45, 0);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome_produto = 'Picanha'").getSingleResult();
            iv.setProduto(p);
            em.persist(iv);

            iv = new ItemVenda(8, 5, 10);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome_produto = 'Coca'").getSingleResult();
            iv.setProduto(p);
            em.persist(iv);

            iv = new ItemVenda(2, 15, 5);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome_produto = 'Pao de alho'").getSingleResult();
            iv.setProduto(p);
            em.persist(iv);

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
