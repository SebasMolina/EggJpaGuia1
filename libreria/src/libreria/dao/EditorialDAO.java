
package libreria.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;
import libreria.interfaces.CRUDDAO;

/**
 *
 * @author Sebas
 */
public class EditorialDAO implements CRUDDAO <Editorial, Integer>{

    @Override
    public void insertar(Editorial editorial) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.persist(editorial);
            EM.getTransaction().commit();
        } catch (Exception e) {
            EM.getTransaction().rollback();
            throw new Exception("Error al insertar Editorial");
        }
        
    }

    @Override
    public void modificar(Editorial editorial) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.merge(editorial);
            EM.getTransaction().commit();
        } catch (Exception e) {
            CRUDDAO.EM.getTransaction().rollback();
            throw new Exception("Error al actualizar Editorial");
        }
    }

    @Override
    public void eliminar(Editorial editorial) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.remove(editorial);
            EM.getTransaction().commit();
        } catch (Exception e) {
            CRUDDAO.EM.getTransaction().rollback();
            throw new Exception("Error al eliminar Editorial");
        }
    }

    @Override
    public List<Editorial> obtenerTodos() throws Exception {
        try {
            List<Editorial> editoriales = EM.createQuery("SELECT e FROM Editorial e", Editorial.class)
                    .getResultList();
            return editoriales;
        } catch (Exception e) {
            throw new Exception("Error al buscar las editoriales");
        }
        
    }

    @Override
    public Editorial obtenerPorId(Integer id) throws Exception {
        try {
            Editorial editorial = EM.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id", Editorial.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return editorial;
        } catch (Exception e) {
            throw new Exception("Error al buscar editorial por id");
        }
    }

    @Override
    public List<Editorial> obtenerPorNombre(String nombre) throws Exception {
        try {
            List<Editorial> editoriales = EM.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :name", Editorial.class)
                    .setParameter("name", nombre)
                    .getResultList();
            return editoriales;
        } catch (Exception e) {
            throw new Exception("Error al buscar las editoriales por nombre");
        }
    }

    @Override
    public void cambiarEstado(Editorial editorial) throws Exception {
        try {
            editorial.setAlta(!editorial.isAlta());
            modificar(editorial);
        } catch (Exception e) {
            throw new Exception("Error al cambiar el estado de la editorial");
        }
    
    }
    
    
    
    
    
    
}
