package com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoCarga;
import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaCarga;
import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.servicio.ServicioCarga;

@Component
public class ManejadorCrearCarga {
	private final ServicioCarga servicioCrearCarga;
	private final CentralMayoristaCarga centralMayoristaCarga;
	
	public ManejadorCrearCarga(ServicioCarga servicioCrearCarga,CentralMayoristaCarga centralMayoristaCarga) {
		this.servicioCrearCarga = servicioCrearCarga;
		this.centralMayoristaCarga = centralMayoristaCarga;
	}
	
	public void crear(ComandoCarga comandoCarga, Distribuidor distribuidor) {		
		Carga carga = this.centralMayoristaCarga.crear(comandoCarga);
		this.servicioCrearCarga.crear(carga,distribuidor);
	}	
}
