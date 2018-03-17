package com.mit.model;

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "transport_master")
public class TransportMaster implements Serializable {
 
    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transporterId;
 
    @Column
    private String transporterName;
 
    @Column
    private String transporterVehicalNumber;
 
    @Column
    private String transporterVehicalType;
 
    @Column
    private int transporterFeetCapacity;

	public int getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(int transporterId) {
		this.transporterId = transporterId;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterVehicalNumber() {
		return transporterVehicalNumber;
	}

	public void setTransporterVehicalNumber(String transporterVehicalNumber) {
		this.transporterVehicalNumber = transporterVehicalNumber;
	}

	public String getTransporterVehicalType() {
		return transporterVehicalType;
	}

	public void setTransporterVehicalType(String transporterVehicalType) {
		this.transporterVehicalType = transporterVehicalType;
	}

	public int getTransporterFeetCapacity() {
		return transporterFeetCapacity;
	}

	public void setTransporterFeetCapacity(int transporterFeetCapacity) {
		this.transporterFeetCapacity = transporterFeetCapacity;
	}
 
    
}