
package pe.idat.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.idat.dao.ProfesorDao;
import pe.idat.model.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    @Qualifier("profesorDaoImpl")
    private ProfesorDao profesorDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(Profesor profesor) {
        profesorDao.insert(profesor);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Profesor profesor) {
        profesorDao.update(profesor);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_profesor) {
        profesorDao.delete(id_profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findById(Integer id_profesor) {
        return profesorDao.findById(id_profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Profesor> findAll() {
        return profesorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean ifExist(Integer id_profesor) {
        return profesorDao.ifExist(id_profesor);
    }
    
}
