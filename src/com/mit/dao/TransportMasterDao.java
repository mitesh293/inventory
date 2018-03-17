package com.mit.dao;

import java.util.List;

import com.mit.model.TransportMaster;

public interface TransportMasterDao {
	public void addTransportMaster(TransportMaster TransportMaster);
	 
    public List<TransportMaster> getAllTransportMasters();
 
    public void deleteTransportMaster(Integer TransportMasterId);
 
    public TransportMaster updateTransportMaster(TransportMaster TransportMaster);
 
    public TransportMaster getTransportMaster(int TransportMasterid);
}
