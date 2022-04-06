
package libreria.interfaces;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Sebas
 */
public interface CRUDDAO <T, N> {
    
    EntityManager EM = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();
    
    void insertar(T t) throws Exception;
    
    void modificar(T t) throws Exception;
    
    void eliminar(T t) throws Exception;
    
    List<T> obtenerTodos() throws Exception;
    
    T obtenerPorId(N id) throws Exception;
    
    List<T> obtenerPorNombre(String nombre) throws Exception;
    
    void cambiarEstado(T t) throws Exception;
}
