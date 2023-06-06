package ifmt.cba.apps;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppProdutoFornecedor {
    
    public static void main(String args[]){
        try {
            
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT g FROM Produto g WHERE nome_produto = 'Coca'");
            Produto p = (Produto)query.getSingleResult();
            query= em.createQuery("SELECT g FROM Fornecedor g WHERE razaoSocial = 'Venda de bebidas'");
            Fornecedor f = (Fornecedor)query.getSingleResult();


            f.getProduto().add(p);
            p.getFornecedor().add(f);

            em.persist(p);
            em.persist(f);


            query = em.createQuery("SELECT g FROM Produto g WHERE nome_produto = 'Picanha'");
            p = (Produto)query.getSingleResult();
            query= em.createQuery("SELECT g FROM Fornecedor g WHERE razaoSocial = 'Venda de carne'");
            f = (Fornecedor)query.getSingleResult();


            f.getProduto().add(p);
            p.getFornecedor().add(f);

            em.persist(p);
            em.persist(f);

            query = em.createQuery("SELECT g FROM Produto g WHERE nome_produto = 'Pao de alho'");
            p = (Produto)query.getSingleResult();
            query= em.createQuery("SELECT g FROM Fornecedor g WHERE razaoSocial = 'padaria'");
            f = (Fornecedor)query.getSingleResult();


            f.getProduto().add(p);
            p.getFornecedor().add(f);

            em.persist(p);
            em.persist(f);



            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

 