package com.parking.smartBici.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.smartBici.db.DatabaseAccess;
import com.parking.smartBici.dto.IngresoDTO;

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
	
	
	public String ingresarCliente(IngresoDTO ingresodto) {
		
		try {
			
	    	//ANTES DE INGRESAR CLIENTE, TENGO QUE CONSULTAR SI EXISTE LA CEDULA EN CUESTION
	    	//boolean existe = databaseAccess.existeCliente(ingresodto)
			//if(!existe)			
				databaseAccess.guardarCliente(ingresodto);
			//else return "ya esta registrado."
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

}

