package libreria.servicio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Sebas
 */
public class PrincipalServicio {
    
    private final EntityManager EM;

    public PrincipalServicio() {
        EM = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();
    }
    
    
}
