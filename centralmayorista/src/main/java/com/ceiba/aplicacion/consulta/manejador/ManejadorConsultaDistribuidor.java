package com.ceiba.aplicacion.consulta.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaDistribuidor;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.servicio.dao.ServicioDistribuidorDao;

@Component
public class ManejadorConsultaDistribuidor {
	private final ServicioDistribuidorDao servicioDistribuidor;
	private final CentralMayoristaDistribuidor centralMayoristaDistribuidor;
	
	public ManejadorConsultaDistribuidor(ServicioDistribuidorDao servicioDistribuidor,CentralMayoristaDistribuidor centralMayoristaDistribuidor) {
		this.servicioDistribuidor = servicioDistribuidor;
		this.centralMayoristaDistribuidor = centralMayoristaDistribuidor;
	}
	
	public Distribuidor obtenerPorId(long id) {
		return this.servicioDistribuidor.obtenerPorId(id);
	}
}
