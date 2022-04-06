
package libreria.dao;

import java.util.List;
import libreria.entidades.Libro;
import libreria.interfaces.CRUDDAO;

/**
 *
 * @author Sebas
 */
public class LibroDAO implements CRUDDAO <Libro, Long>{
    
    @Override
    public void insertar(Libro libro) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.persist(libro);
            EM.getTransaction().commit();
        } catch (Exception e) {
            EM.getTransaction().rollback();
            throw new Exception("Error al insertar Libro");
        }
    }

    @Override
    public void modificar(Libro libro) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.merge(libro);
            EM.getTransaction().commit();
        } catch (Exception e) {
            EM.getTransaction().rollback();
            throw new Exception("Error al actualizar Libro");
        }
    }

    @Override
    public void eliminar(Libro libro) throws Exception {
        try {
            EM.getTransaction().begin();
            EM.remove(libro);
            EM.getTransaction().commit();
        } catch (Exception e) {
            CRUDDAO.EM.getTransaction().rollback();
            throw new Exception("Error al eliminar Autor");
        }
        
    }

    @Override
    public List<Libro> obtenerTodos() throws Exception {
        try {
            List<Libro> libros = EM.createQuery("SELECT l FROM Libro l", Libro.class)
                    .getResultList();
            return libros;
        } catch (Exception e) {
            throw new Exception("Error al buscar los libros");
        }
    }

    @Override
    public Libro obtenerPorId(Long id) throws Exception {
        try {
            Libro libro = EM.createQuery("SELECT l FROM Libro l WHERE l.ISBN LIKE :id", Libro.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return libro;
        } catch (Exception e) {
            throw new Exception("Error al buscar libro por ISBN");
        }
    }

    @Override
    public List<Libro> obtenerPorNombre(String nombre) throws Exception {
        try {
            List<Libro> libros = EM.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :name", Libro.class)
                    .setParameter("name", nombre)
                    .getResultList();
            return libros;
        } catch (Exception e) {
            throw new Exception("Error al buscar los libros por nombre");
        }
    }

    @Override
    public void cambiarEstado(Libro libro) throws Exception {
        try {
            libro.setAlta(!libro.isAlta());
            modificar(libro);
        } catch (Exception e) {
            throw new Exception("Error al cambiar el estado del autor");
        }
    }
    
    
    
    
}
