package com.ceiba.framework.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aplicacion.comando.ComandoCarga;
import com.ceiba.aplicacion.comando.manejador.ManejadorCrearCarga;

@RestController
@RequestMapping("/api/v1/cargas")
public class ComandoControladorCarga {
	private final ManejadorCrearCarga manejadorCrearCarga;
	
	public ComandoControladorCarga(ManejadorCrearCarga manejadorCrearCarga) {
		this.manejadorCrearCarga = manejadorCrearCarga;
	}
	
	@PostMapping("")
	public ResponseEntity<String> crear(@RequestBody ComandoCarga comandoCarga){
		this.manejadorCrearCarga.crear(comandoCarga);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registro Ingresado exitosamente");
	}
}
