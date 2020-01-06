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

import com.ceiba.aplicacion.comando.ComandoCarga;
import com.ceiba.aplicacion.comando.manejador.ManejadorCrearCarga;
import com.ceiba.aplicacion.consulta.manejador.ManejadorConsultaCarga;
import com.ceiba.aplicacion.consulta.manejador.ManejadorConsultaDistribuidor;
import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;

@RestController
@RequestMapping("/api/v1/cargas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ComandoControladorCarga {
	private final ManejadorCrearCarga manejadorCrearCarga;
	private final ManejadorConsultaCarga manejadorListarCargas;
	private final ManejadorConsultaDistribuidor manejadorConsultaDistribuidor;

	public ComandoControladorCarga(ManejadorCrearCarga manejadorCrearCarga,
			ManejadorConsultaCarga manejadorConsultaCarga,
			ManejadorConsultaDistribuidor manejadorConsultaDistribuidor) {
		this.manejadorCrearCarga = manejadorCrearCarga;
		this.manejadorListarCargas = manejadorConsultaCarga;
		this.manejadorConsultaDistribuidor = manejadorConsultaDistribuidor;
	}

	@PostMapping("")
	public ResponseEntity<String> crear(@RequestBody ComandoCarga comandoCarga) {

		try {
			Distribuidor distribuidor = this.manejadorConsultaDistribuidor
					.obtenerPorId(comandoCarga.getDistribuidorId());
			this.manejadorCrearCarga.crear(comandoCarga, distribuidor);
			return ResponseEntity.status(HttpStatus.CREATED).body("Carga almacenada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("" + e.getMessage());
		}

	}

	@GetMapping("/{distribuidor_id}/listar")
	public ResponseEntity<List> listar(@PathVariable(name = "distribuidor_id") long distribuidorId) {
		List<Carga> cargas = this.manejadorListarCargas.listar(distribuidorId);
		return ResponseEntity.status(HttpStatus.OK).body(cargas);
	}
}
