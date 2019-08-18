
package pe.idat.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.idat.model.Profesor;

@Repository
public class ProfesorDaoImpl implements ProfesorDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(Profesor profesor) {
        entityManager.persist(profesor);
    }

    @Override
    public void update(Profesor profesor) {
        entityManager.merge(profesor);
    }

    @Override
    public void delete(Integer id_profesor) {
        entityManager.remove(findById(id_profesor));
    }

    @Override
    public Profesor findById(Integer id_profesor) {
        return entityManager.find(Profesor.class, id_profesor);
    }

    @Override
    public Collection<Profesor> findAll() {
        
        Query query = entityManager.createNativeQuery("select * from profesores", Profesor.class);
        
        return query.getResultList();
    }

    @Override
    public boolean ifExist(Integer id_profesor) {
        return entityManager.contains(id_profesor);
    }
    
}
