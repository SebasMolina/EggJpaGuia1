
package libreria.principal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

/**
 *
 * @author Sebas
 */
public class principal {

    
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();
        
        em.getTransaction().begin();
        
        Editorial ed = new Editorial("Daniel",false);
        
        em.persist(ed);
        
        em.getTransaction().commit();
        
    }
    
}
