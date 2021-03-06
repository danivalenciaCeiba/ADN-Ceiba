package com.ceiba.aplicacion.comando.manejador;


import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoDistribuidor;
import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaDistribuidor;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.servicio.ServicioGuardarDistribuidor;

@Component
public class ManejadorCrearDistribuidor {
		
	private final ServicioGuardarDistribuidor servicioCrearDistribuidor;
	private final CentralMayoristaDistribuidor centralMayoristaDistribuidor;
	
	public ManejadorCrearDistribuidor(ServicioGuardarDistribuidor servicioCrearDistribuidor,CentralMayoristaDistribuidor centralMayoristaDistribuidor) {
		this.servicioCrearDistribuidor = servicioCrearDistribuidor;
		this.centralMayoristaDistribuidor = centralMayoristaDistribuidor;
	}
		
	public Distribuidor crear(ComandoDistribuidor comandoDistribuidor) {
		Distribuidor distribuidor = this.centralMayoristaDistribuidor.crear(comandoDistribuidor);
		return this.servicioCrearDistribuidor.crear(distribuidor);
	}
}
