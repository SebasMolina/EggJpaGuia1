
package libreria.dao;

import java.util.List;
import libreria.entidades.Autor;
import libreria.interfaces.CRUDDAO;

/**
 *
 * @author Sebas
 */
public class AutorDAO implements CRUDDAO <Autor, Integer>{

    @Override
    public void insertar(Autor autor) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.persist(autor);
            EM.getTransaction().commit();
        } catch (Exception e) {
            EM.getTransaction().rollback();
            throw new Exception("Error al insertar Autor");
        }
    }

    @Override
    public void modificar(Autor autor) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.merge(autor);
            EM.getTransaction().commit();
        } catch (Exception e) {
            EM.getTransaction().rollback();
            throw new Exception("Error al actualizar Autor");
        }
    }

    @Override
    public void eliminar(Autor autor) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.remove(autor);
            EM.getTransaction().commit();
        } catch (Exception e) {
            CRUDDAO.EM.getTransaction().rollback();
            throw new Exception("Error al eliminar Autor");
        }
    }

    @Override
    public List<Autor> obtenerTodos() throws Exception {
        try {
            List<Autor> autores = EM.createQuery("SELECT a FROM Autor a", Autor.class)
                    .getResultList();
            return autores;
        } catch (Exception e) {
            throw new Exception("Error al buscar los autores");
        }
    }

    @Override
    public Autor obtenerPorId(Integer id) throws Exception {
        try {
            Autor autor = EM.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id", Autor.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return autor;
        } catch (Exception e) {
            throw new Exception("Error al buscar autor por id");
        }
    }

    @Override
    public List<Autor> obtenerPorNombre(String nombre) throws Exception {
        try {
            List<Autor> autores = EM.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :name", Autor.class)
                    .setParameter("name", nombre)
                    .getResultList();
            return autores;
        } catch (Exception e) {
            throw new Exception("Error al buscar los autores por nombre");
        }
    }

    @Override
    public void cambiarEstado(Autor autor) throws Exception{
        try {
            autor.setAlta(!autor.isAlta());
            modificar(autor);
        } catch (Exception e) {
            throw new Exception("Error al cambiar el estado del autor");
        }
    }
    

    
    
    
}
