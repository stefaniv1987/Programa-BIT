package com.parking.smartBici.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.smartBici.dto.MobileDTO;
import com.parking.smartBici.services.ParkingServices;

@RequestMapping(value = {"mobile"})
@RestController
public class MobileController {

	private static ParkingServices parkingServices;

	@Autowired
	public MobileController(ParkingServices parkingServices) {
		
		this.parkingServices = parkingServices;
	
	}
	
	@RequestMapping(value = "/lugaresdisponibles", method = RequestMethod.GET)
	public MobileDTO disponibilidad(){
		
		Integer lugares = parkingServices.lugaresDisponibles();
		
		MobileDTO mobileDTO= new MobileDTO();
		mobileDTO.setLugaresDisponibles(lugares);
		
		
		return mobileDTO;
		
	}
	
	
	
}
