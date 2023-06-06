package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import jakarta.persistence.EntityManager;

public class AppCliente {
    public static void main (String args[]){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Mateus Goulart", "123", "12", 2000);
            em.persist(cliente);

            cliente = new Cliente("Heloise", "456", "45", 2500);
            em.persist(cliente);

            cliente = new Cliente("Samuel", "789", "78", 3000);
            em.persist(cliente);

            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
