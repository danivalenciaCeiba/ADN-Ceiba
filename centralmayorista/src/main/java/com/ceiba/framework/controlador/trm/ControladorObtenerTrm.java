package com.ceiba.framework.controlador.trm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.framework.servicio.trm.TCRMTestClient;

@RestController
@RequestMapping("/api/v1/trm")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ControladorObtenerTrm {
	private final TCRMTestClient trmService;
	
	public ControladorObtenerTrm(TCRMTestClient trmService) {
		this.trmService = trmService;
	}
	
	@GetMapping("")
	public ResponseEntity<String> obtenerTrm() {
		try {
			String trm = this.trmService.obtenerTrm();
			return ResponseEntity.status(HttpStatus.OK).body(trm);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
}
