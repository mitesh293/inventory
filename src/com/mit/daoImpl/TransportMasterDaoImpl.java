package com.mit.daoImpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mit.dao.TransportMasterDao;
import com.mit.model.TransportMaster;
 
 
@Repository
public class TransportMasterDaoImpl implements TransportMasterDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addTransportMaster(TransportMaster TransportMaster) {
        sessionFactory.getCurrentSession().saveOrUpdate(TransportMaster);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<TransportMaster> getAllTransportMasters() {
 
        return sessionFactory.getCurrentSession().createQuery("from TransportMaster")
                .list();
    }
 
    @Override
    public void deleteTransportMaster(Integer TransportMasterId) {
        TransportMaster TransportMaster = (TransportMaster) sessionFactory.getCurrentSession().load(
                TransportMaster.class, TransportMasterId);
        if (null != TransportMaster) {
            this.sessionFactory.getCurrentSession().delete(TransportMaster);
        }
 
    }
 
    public TransportMaster getTransportMaster(int empid) {
        return (TransportMaster) sessionFactory.getCurrentSession().get(
                TransportMaster.class, empid);
    }
 
    @Override
    public TransportMaster updateTransportMaster(TransportMaster TransportMaster) {
        sessionFactory.getCurrentSession().update(TransportMaster);
        return TransportMaster;
    }
 
}