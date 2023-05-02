package ifmt.cba.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FabricaEntityManager {
    
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("JPACamadas");
    }

    private FabricaEntityManager(){

    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            return null;
        } else {
            return emf.createEntityManager();
        }
    }
}
