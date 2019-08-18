
package pe.idat.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.idat.model.Colegio;

@Repository
public class ColegioDaoImpl implements ColegioDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(Colegio colegio) {
        entityManager.persist(colegio);
    }

    @Override
    public void update(Colegio colegio) {
        entityManager.merge(colegio);
    }

    @Override
    public void delete(Integer id_colegio) {
        entityManager.remove(findById(id_colegio));
    }

    @Override
    public Colegio findById(Integer id_colegio) {
        return entityManager.find(Colegio.class, id_colegio);
    }

    @Override
    public Collection<Colegio> findAll() {
        
        Query query = entityManager.createNativeQuery("select * from colegios", Colegio.class);
        
        return query.getResultList();
    }

    @Override
    public boolean ifExist(Integer id_colegio) {
        return entityManager.contains(id_colegio);
    }
    
}
