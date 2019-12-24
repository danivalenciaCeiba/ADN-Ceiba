package com.ceiba.comando.manejador;


import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoDistribuidor;
import com.ceiba.comando.centralmayorista.CentralMayoristaDistribuidor;
import com.ceiba.modelo.entidad.Distribuidor;
import com.ceiba.puerto.servicio.ServicioCrearDistribuidor;

@Component
public class ManejadorCrearDistribuidor {
		
	private final ServicioCrearDistribuidor servicioCrearDistribuidor;
	private final CentralMayoristaDistribuidor centralMayoristaDistribuidor;
	
	public ManejadorCrearDistribuidor(ServicioCrearDistribuidor servicioCrearDistribuidor,CentralMayoristaDistribuidor centralMayoristaDistribuidor) {
		this.servicioCrearDistribuidor = servicioCrearDistribuidor;
		this.centralMayoristaDistribuidor = centralMayoristaDistribuidor;
	}
		
	public void crear(ComandoDistribuidor comandoDistribuidor) {
		Distribuidor distribuidor = this.centralMayoristaDistribuidor.crear(comandoDistribuidor);
		this.servicioCrearDistribuidor.crear(distribuidor);
	}
}
