
package pe.idat.service;

import java.util.Collection;
import pe.idat.model.Colegio;


public interface ColegioService {
    
    public abstract void insert(Colegio colegio);
    public abstract void update(Colegio colegio);
    public abstract void delete(Integer id_colegio);
    
    public abstract Colegio findById(Integer id_colegio);
    public abstract Collection<Colegio> findAll();
    public abstract boolean ifExist(Integer id_colegio);
    
}
