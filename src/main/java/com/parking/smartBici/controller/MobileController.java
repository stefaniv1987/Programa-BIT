package com.parking.smartBici.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parking.smartBici.dto.IngresoDTO;
import com.parking.smartBici.dto.MobileDTO;
import com.parking.smartBici.services.ParkingServices;



@RequestMapping(value = { "mobile" })
@RestController
public class MobileController {

	private static ParkingServices parkingServices;

	@Autowired
	public MobileController(ParkingServices parkingServices) {

		this.parkingServices = parkingServices;

	}

	@RequestMapping(value = "/lugaresdisponibles", method = RequestMethod.GET)
	public MobileDTO disponibilidad() {

		Integer lugares = parkingServices.lugaresDisponibles();

		MobileDTO mobileDTO = new MobileDTO();
		mobileDTO.setLugaresDisponibles(lugares);

		return mobileDTO;

	}

	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public ResponseEntity<String> entrar(@RequestParam(name = "cedula") String cedula) {

		try {
			IngresoDTO ingresodto = new IngresoDTO();
			ingresodto.setCedula(cedula);

			boolean hayLugares = parkingServices.hayLugares();

			if (hayLugares == true) {
				parkingServices.ingresarCliente(ingresodto);
				parkingServices.decrementarContador();

				return new ResponseEntity<>("Ingreso autorizado", HttpStatus.OK);

			} else {
				return new ResponseEntity<>("Ingreso NO autorizado, no hay lugares", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("La cedula ya esta registrada", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/salir", method = RequestMethod.POST)
	public ResponseEntity<String> salir(@RequestParam(name = "cedula") String cedula) {

		IngresoDTO ingresodto= new IngresoDTO();
		ingresodto.setCedula(cedula);
		
		
		try {
			int salida = parkingServices.salidaCliente(ingresodto);
			if (salida == 1) {
				parkingServices.incrementarContador();
				
				return new ResponseEntity<>("Salida autorizada", HttpStatus.OK);
			}
			else
				return new ResponseEntity<>("Cedula no registrada, error", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}






