package com.mit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.TransportMasterDao;
import com.mit.model.TransportMaster;

 
@Service
@Transactional
public class TransportMasterServiceImpl{
 
    @Autowired
    private TransportMasterDao transportMasterDao;
 
    
    @Transactional
    public void addTransportMaster(TransportMaster TransportMaster) {
        transportMasterDao.addTransportMaster(TransportMaster);
    }
 
  
    @Transactional
    public List<TransportMaster> getAllTransportMasters() {
        return transportMasterDao.getAllTransportMasters();
    }
 

    @Transactional
    public void deleteTransportMaster(Integer TransportMasterId) {
        transportMasterDao.deleteTransportMaster(TransportMasterId);
    }
 
    public TransportMaster getTransportMaster(int empid) {
        return transportMasterDao.getTransportMaster(empid);
    }
 
    public TransportMaster updateTransportMaster(TransportMaster TransportMaster) {
        // TODO Auto-generated method stub
        return transportMasterDao.updateTransportMaster(TransportMaster);
    }
 
    public void settransportMasterDao(TransportMasterDao transportMasterDao) {
        this.transportMasterDao = transportMasterDao;
    }
 
}
