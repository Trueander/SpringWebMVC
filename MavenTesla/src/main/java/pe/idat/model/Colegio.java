package pe.idat.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "colegios")
public class Colegio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_colegio;
    
    @Column
    private String nombre;
    
    @Column
    private String distrito;
    
    @Column
    private String tipo;
    
    @OneToMany(mappedBy = "colegio")
    private Collection<Profesor> itemsProfesor;

    public Colegio() {
    }

    public Integer getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(Integer id_colegio) {
        this.id_colegio = id_colegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String Tipo) {
        this.tipo = Tipo;
    }

    public Collection<Profesor> getItemsProfesor() {
        return itemsProfesor;
    }

    public void setItemsProfesor(Collection<Profesor> itemsProfesor) {
        this.itemsProfesor = itemsProfesor;
    }

    
}
