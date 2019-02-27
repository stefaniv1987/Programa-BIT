package com.parking.smartBici.db;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.parking.smartBici.dto.IngresoDTO;

@Component
public class DatabaseAccess {

	private static DatabaseAccess dbonnection;

	@Autowired
	private DatabaseAccess() {
	}

	// Now we are providing global point of access.
	public static DatabaseAccess getInstance() {
		if (dbonnection == null) {
			dbonnection = new DatabaseAccess();
		}
		return dbonnection;
	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con = null;

		try {	

			URI dbUri = new URI("postgres://cyitpjobdpofna:946fe308b5876200a129cf2c0a08967b259a55f474ced5e96164f1cfc0fefde7@ec2-54-235-67-106.compute-1.amazonaws.com:5432/dflqtcff3jc8uq");

			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
		
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath()
					+ "?sslfactory=org.postgresql.ssl.NonValidatingFactory";

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(dbUrl, username, password);

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		return con;

	}
	
	public Integer getLugaresDisponibles() throws SQLException{
		Integer disponibles=null;
		Statement stmt = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = DatabaseAccess.getConnection();
			stmt = connection.createStatement();
			
			String autoIdQuery = "SELECT disponibilidad FROM lugares_disponibles";
					
			rs = stmt.executeQuery(autoIdQuery);

			 while (rs.next()) {
				   disponibles = rs.getInt("disponibilidad");				 
		     }		
			 
		}catch(Exception e){
			
			e.printStackTrace();
			
				
		}finally {
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		System.out.println("lugares disponibles: " + disponibles);
		return disponibles;
	}	
	
	
	public Integer guardarCliente(IngresoDTO ingresodto) throws SQLException{
		
		Statement stmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		

		try {
			connection = DatabaseAccess.getConnection();
			stmt = connection.createStatement();
			
			String query = "INSERT INTO personas_registro"
					+ "(CEDULA, FECHA) VALUES"
					+ "(?,?)";
			
		
	PreparedStatement preparedStatement = connection.prepareStatement(query);
	preparedStatement.setInt(1, Integer.valueOf(ingresodto.getCedula()));
	preparedStatement.setDate(2,sqlDate);
			
	preparedStatement .executeUpdate();
			
				
		}catch(Exception e){
			
			e.printStackTrace();
			
				
		}finally {
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return 0;
	}	
	
	
	
	
}
