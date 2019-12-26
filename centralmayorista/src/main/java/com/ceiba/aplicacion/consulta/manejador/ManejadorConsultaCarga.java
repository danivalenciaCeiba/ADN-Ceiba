package com.ceiba.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaDistribuidor;
import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.servicio.dao.ServicioCargaDao;

@Component
public class ManejadorConsultaCarga {

	private final ServicioCargaDao servicioListarCargas;
	private final CentralMayoristaDistribuidor centralMayoristaDistribuidor;
	
	public ManejadorConsultaCarga(ServicioCargaDao servicioListarCargas, CentralMayoristaDistribuidor centralMayoristaDistribuidor) {
		this.servicioListarCargas = servicioListarCargas;
		this.centralMayoristaDistribuidor = centralMayoristaDistribuidor;
	}
	
	public List<Carga> listar(long distribuidorId){		
		return this.servicioListarCargas.listar(distribuidorId);
	}
}
