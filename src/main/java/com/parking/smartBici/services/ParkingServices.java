package com.parking.smartBici.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.smartBici.db.DatabaseAccess;

@Service
public class ParkingServices {
	
	public DatabaseAccess databaseAccess;

	@Autowired
	public ParkingServices(DatabaseAccess databaseAccess) {
		super();
		this.databaseAccess = databaseAccess;
	}
	
	public Integer lugaresDisponibles(){
		
	Integer cantidad=0;			
	try {
		 cantidad = this.databaseAccess.getLugaresDisponibles();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return cantidad;	
	}
	
	

}
