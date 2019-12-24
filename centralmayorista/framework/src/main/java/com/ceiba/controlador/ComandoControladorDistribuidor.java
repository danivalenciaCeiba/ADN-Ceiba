package com.ceiba.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoDistribuidor;
import com.ceiba.comando.manejador.ManejadorCrearDistribuidor;

@RestController
@RequestMapping("/api/v1")
public class ComandoControladorDistribuidor {
	
	private final ManejadorCrearDistribuidor manejadorCrearDistribuidor;
	
	public ComandoControladorDistribuidor(ManejadorCrearDistribuidor manejadorCrearDistribuidor) {
		this.manejadorCrearDistribuidor = manejadorCrearDistribuidor;
	}
	
	@PostMapping("/distribuidores")	
	public ResponseEntity<String> crear(@RequestBody ComandoDistribuidor comandoDistribuidor) {
		this.manejadorCrearDistribuidor.crear(comandoDistribuidor);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registro Ingresado exitosamente");
	}
	
}
