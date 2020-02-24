package com.parking.smartBici.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MobileDTO {
	
private Integer lugaresDisponibles;
private Boolean ingreso;
private Boolean salida;
private String cedula;


public MobileDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getLugaresDisponibles() {
	return lugaresDisponibles;
}

public void setLugaresDisponibles(Integer lugaresDisponibles) {
	this.lugaresDisponibles = lugaresDisponibles;
}

public Boolean getIngreso() {
	return ingreso;
}

public void setIngreso(Boolean ingreso) {
	this.ingreso = ingreso;
}

public String getCedula() {
	return cedula;
}

public void setCedula(String cedula) {
	this.cedula = cedula;
}

public Boolean getSalida() {
	return salida;
}

public void setSalida(Boolean salida) {
	this.salida = salida;
}






}
