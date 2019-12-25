package com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoCarga;
import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaCarga;
import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.puerto.servicio.ServicioCrearCarga;

@Component
public class ManejadorCrearCarga {
	private final ServicioCrearCarga servicioCrearCarga;
	private final CentralMayoristaCarga centralMayoristaCarga;
	
	public ManejadorCrearCarga(ServicioCrearCarga servicioCrearCarga,CentralMayoristaCarga centralMayoristaCarga) {
		this.servicioCrearCarga = servicioCrearCarga;
		this.centralMayoristaCarga = centralMayoristaCarga;
	}
	
	public void crear(ComandoCarga comandoCarga) {
		Carga carga = this.centralMayoristaCarga.crear(comandoCarga);
		this.servicioCrearCarga.crear(carga);
	}
}
