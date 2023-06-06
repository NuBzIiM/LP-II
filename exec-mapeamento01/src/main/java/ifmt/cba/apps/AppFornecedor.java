package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import jakarta.persistence.EntityManager;

public class AppFornecedor {
    
    public static void main (String args[]){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Fornecedor fornecedor = new Fornecedor("Entrega Padaria", "padaria");
            em.persist(fornecedor);

            fornecedor = new Fornecedor("Entrega Carne", "Venda de carne");
            em.persist(fornecedor);

            fornecedor = new Fornecedor("Entrega Bebidas", "Venda de bebidas");
            em.persist(fornecedor);

            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
