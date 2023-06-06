package ifmt.cba.apps;



import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppVendaRelacoes {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            Venda v;
            ItemVenda iv;
            Cliente c;
            Vendedor vr;

            em.getTransaction().begin();
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo_venda = 1");
            v = (Venda)query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo_item = 1");
            iv = (ItemVenda)query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Mateus Goulart'");
            c = (Cliente)query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Joyce'");
            vr = (Vendedor)query.getSingleResult();

            v.getItem_venda().add(iv);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVenda().add(v);
            vr.getVenda().add(v);

            em.persist(vr);
            em.persist(v);
            em.persist(iv);
            em.persist(c);

            
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo_venda = 2");
            v = (Venda)query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo_item = 2");
            iv = (ItemVenda)query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Heloise'");
            c = (Cliente)query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Julio'");
            vr = (Vendedor)query.getSingleResult();

            v.getItem_venda().add(iv);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVenda().add(v);
            vr.getVenda().add(v);

            em.persist(vr);
            em.persist(v);
            em.persist(iv);
            em.persist(c);

            
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo_venda = 3");
            v = (Venda)query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo_item = 3");
            iv = (ItemVenda)query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Samuel'");
            c = (Cliente)query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Elizeu'");
            vr = (Vendedor)query.getSingleResult();

            v.getItem_venda().add(iv);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVenda().add(v);
            vr.getVenda().add(v);

            em.persist(vr);
            em.persist(v);
            em.persist(iv);
            em.persist(c);

            
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo_venda = 4");
            v = (Venda)query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo_item = 4");
            iv = (ItemVenda)query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Mateus Goulart'");
            c = (Cliente)query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Elizeu'");
            vr = (Vendedor)query.getSingleResult();

            v.getItem_venda().add(iv);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVenda().add(v);
            vr.getVenda().add(v);

            em.persist(vr);
            em.persist(v);
            em.persist(iv);
            em.persist(c);

            
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo_venda = 5");
            v = (Venda)query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo_item = 5");
            iv = (ItemVenda)query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Heloise'");
            c = (Cliente)query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Joyce'");
            vr = (Vendedor)query.getSingleResult();

            v.getItem_venda().add(iv);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVenda().add(v);
            vr.getVenda().add(v);

            em.persist(vr);
            em.persist(v);
            em.persist(iv);
            em.persist(c);


            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
