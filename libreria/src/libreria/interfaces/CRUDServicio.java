
package libreria.interfaces;

import java.util.Set;

/**
 *
 * @author Sebas
 */
public interface CRUDServicio <T> {
    
    T encontrarPorNombre(String nombre) throws Exception;
    
    Set<T> encontrarTodos() throws Exception;
    
    T encontrarPorId(Integer id) throws Exception;
    
    T guardar(T t) throws Exception;
    
    void eliminar(T t) throws Exception;
    
    void eliminarPorId(Integer id) throws Exception;
    
    
}
