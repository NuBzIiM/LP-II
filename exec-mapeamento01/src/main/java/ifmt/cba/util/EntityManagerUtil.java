package ifmt.cba.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("Vendas");
    }

    private EntityManagerUtil(){

    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            return null;
        } else {
            return emf.createEntityManager();
        }
    }
}
