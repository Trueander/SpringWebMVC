
package pe.idat.dao;

import java.util.Collection;
import pe.idat.model.Profesor;


public interface ProfesorDao {
    
    public abstract void insert(Profesor profesor);
    public abstract void update(Profesor profesor);
    public abstract void delete(Integer id_profesor);
    
    public abstract Profesor findById(Integer id_profesor);
    public abstract Collection<Profesor> findAll();
    public abstract boolean ifExist(Integer id_profesor);
    
}
