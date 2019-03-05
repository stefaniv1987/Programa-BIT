package com.parking.smartBici.controller;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parking.smartBici.dto.IngresoDTO;
import com.parking.smartBici.services.ParkingServices;

@Controller
public class SmartParkingController {

	private static ParkingServices parkingServices;

	@Autowired
	public SmartParkingController(ParkingServices parkingServices) {
		super();
		this.parkingServices = parkingServices;
	}

	@GetMapping("/disponibilidad")
	@ResponseBody
	public String disponibilidad() throws JSONException {

		Integer num = parkingServices.lugaresDisponibles();

		return num.toString();
	}

	@GetMapping("/ingreso")
	public String greetingForm(Model model) {
		model.addAttribute("ingresodto", new IngresoDTO());
		return "ingreso";
	}

	@PostMapping("/ingreso")
	public String greetingSubmit(Model model, @ModelAttribute IngresoDTO ingresodto) {

		model.addAttribute("ingresodto", ingresodto);

		try {
			
			
			boolean hayLugares=parkingServices.hayLugares();
			if (hayLugares==true) {
				parkingServices.ingresarCliente(ingresodto);
				parkingServices.decrementarContador();
				return "result";				
			}else {return "errorNoHayLugar";
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}

	}

	@GetMapping("/salida")
	public String salidaForm(Model model) {
		model.addAttribute("ingresodto", new IngresoDTO());
		return "egreso";
	}

	@PostMapping("/salida")
	public String salidaSubmit(Model model, @ModelAttribute IngresoDTO ingresodto) {

		model.addAttribute("ingresodto", ingresodto);

		try {
			int salida = parkingServices.salidaCliente(ingresodto);
			if (salida == 1) {
				parkingServices.incrementarContador();
				return "salida";
			}
			else
				return "errorSalida";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}

	}

}
