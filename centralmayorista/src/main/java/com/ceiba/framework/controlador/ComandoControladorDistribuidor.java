package com.ceiba.framework.controlador;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.aplicacion.comando.ComandoDistribuidor;
import com.ceiba.aplicacion.comando.manejador.ManejadorCrearDistribuidor;
import com.ceiba.aplicacion.consulta.manejador.ManejadorConsultaDistribuidor;
import com.ceiba.dominio.modelo.entidad.Distribuidor;


@RestController
@RequestMapping("/api/v1/distribuidores")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
public class ComandoControladorDistribuidor {
	
	private final ManejadorCrearDistribuidor manejadorCrearDistribuidor;
	private final ManejadorConsultaDistribuidor manejadorConsultaDistribuidor;
	
	public ComandoControladorDistribuidor(ManejadorCrearDistribuidor manejadorCrearDistribuidor, ManejadorConsultaDistribuidor manejadorConsultaDistribuidor) {
		this.manejadorCrearDistribuidor = manejadorCrearDistribuidor;
		this.manejadorConsultaDistribuidor = manejadorConsultaDistribuidor;
	}
	
	@PostMapping("")	
	public ResponseEntity<String> crear(@RequestBody ComandoDistribuidor comandoDistribuidor) {
		try {
			Distribuidor distribuidor = this.manejadorCrearDistribuidor.crear(comandoDistribuidor);
			return ResponseEntity.status(HttpStatus.CREATED).body(distribuidor.getId()+"");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(""+e.getMessage());
		}
		
	}
	
	@GetMapping("/{nit}/buscar-por-nit")	
	public ResponseEntity<Distribuidor> obtenerPorId(@PathVariable(name = "nit") String nit){	
		try {
			Distribuidor distribuidor = this.manejadorConsultaDistribuidor.obtenerPorNit(nit+"");
			return ResponseEntity.status(HttpStatus.OK).body(distribuidor);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		
	}
	
}
