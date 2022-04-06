
package libreria.principal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.servicio.PrincipalServicio;

/**
 *
 * @author Sebas
 */
public class Principal {

    
    public static void main(String[] args) {
        PrincipalServicio servicio = new PrincipalServicio();
        
        //em.getTransaction().begin();
        /*
        Editorial ed = new Editorial("Daniel",false);
        
        em.persist(ed);
        
        em.getTransaction().commit();
        */
        
    }
    
}
