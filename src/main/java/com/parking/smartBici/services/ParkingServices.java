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
	
	
	public String ingresarCliente(IngresoDTO ingresodto) throws SQLException, ClassNotFoundException {
		
		java.util.Date date = new java.util.Date();	
				databaseAccess.guardarCliente(ingresodto,date);
				databaseAccess.insertarHistorico(ingresodto,date);				
		
		return null;
	}
	
	public int salidaCliente(IngresoDTO ingresodto) throws SQLException, ClassNotFoundException {
		
		
		int salida= databaseAccess.eliminarCliente(ingresodto);
		
				

return salida;
}

	public void incrementarContador() throws SQLException{
		
		databaseAccess.incrementarContador();
		
	}

public void decrementarContador() throws SQLException{
		
		databaseAccess.decrementarContador();
		
	}
	
public boolean hayLugares() throws SQLException	{
	boolean hayLugares= databaseAccess.hayLugares();
	
	return hayLugares;
}  

}

