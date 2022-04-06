
package libreria.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sebas
 */
@Entity
@Table(name="editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private int id;
    @Column(name= "nombre", nullable = false)
    private String nombre;
    @Column(name= "alta", nullable = false)
    private boolean alta;

    public Editorial() {
    }

    public Editorial(String nombre, boolean alta) {
        //this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    
    @Override
    public String toString() {
        return String.format("Editorial: %d, nombre: %s, alta: %s",id,nombre,alta);
    }
}
