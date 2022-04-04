package jpa.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jpa.entity.Maker;

public class MakerDAO {

    private final EntityManager em = Persistence
            .createEntityManagerFactory("JPAPU")
            .createEntityManager();

    public void insert(Maker maker) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(maker);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al insertar fabricante");
        }
    }

    public void update(Maker maker) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(maker);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar fabricante");
        }
    }

    public void delete(Maker maker) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(maker);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al insertar fabricante");
        }
    }

    public Maker getByCode(Integer code) throws Exception {
        try {
            Maker maker = em.find(Maker.class, code);
            return maker;
        } catch (Exception e) {
            throw new Exception("Error al buscar fabricante por código");
        }
    }

    public List<Maker> getAll() throws Exception {
        try {
            List<Maker> makers = em.createQuery("SELECT m FROM Maker m", Maker.class)
                    .getResultList();
            return makers;
        } catch (Exception e) {
            throw new Exception("Error al buscar fabricantes");
        }
    }

    public List<Maker> getByName(String name) throws Exception {
        try {
            List<Maker> makers = em.createQuery("SELECT m FROM Maker m WHERE m.name LIKE :name", Maker.class)
                    .setParameter("name", name)
                    .getResultList();
            return makers;
        } catch (Exception e) {
            throw new Exception("Error al buscar fabricantes por nombre");
        }
    }
}
