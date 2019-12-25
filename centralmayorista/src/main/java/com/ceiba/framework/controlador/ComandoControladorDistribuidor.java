package com.ceiba.framework.controlador;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aplicacion.comando.ComandoDistribuidor;
import com.ceiba.aplicacion.comando.manejador.ManejadorCrearDistribuidor;
import com.ceiba.dominio.modelo.entidad.Distribuidor;


@RestController
@RequestMapping("/api/v1/distribuidores")
public class ComandoControladorDistribuidor {
	
	private final ManejadorCrearDistribuidor manejadorCrearDistribuidor;
	
	public ComandoControladorDistribuidor(ManejadorCrearDistribuidor manejadorCrearDistribuidor) {
		this.manejadorCrearDistribuidor = manejadorCrearDistribuidor;
	}
	
	@PostMapping("")	
	public ResponseEntity<String> crear(@RequestBody ComandoDistribuidor comandoDistribuidor) {
		Distribuidor distribuidor = this.manejadorCrearDistribuidor.crear(comandoDistribuidor);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registro Ingresado exitosamente"+": "+distribuidor.getId());
	}
	
}
