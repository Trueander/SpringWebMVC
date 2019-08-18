
package pe.idat.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.idat.dao.ColegioDao;
import pe.idat.model.Colegio;

@Service
public class ColegioServiceImpl implements ColegioService{

    @Autowired
    @Qualifier("colegioDaoImpl")
    private ColegioDao colegioDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(Colegio colegio) {
        colegioDao.insert(colegio);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Colegio colegio) {
        colegioDao.update(colegio);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_colegio) {
        colegioDao.delete(id_colegio);
    }

    @Override
    @Transactional(readOnly = true)
    public Colegio findById(Integer id_colegio) {
        return colegioDao.findById(id_colegio);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Colegio> findAll() {
        return colegioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean ifExist(Integer id_colegio) {
        return colegioDao.ifExist(id_colegio);
    }
    
    
    
}
