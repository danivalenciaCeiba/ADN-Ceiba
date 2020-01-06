package com.ceiba.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaDistribuidor;
import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.servicio.dao.ServicioCargaDao;

@Component
public class ManejadorConsultaCarga {

	private final ServicioCargaDao servicioListarCargas;
	
	public ManejadorConsultaCarga(ServicioCargaDao servicioListarCargas) {
		this.servicioListarCargas = servicioListarCargas;
	}
	
	public List<Carga> listar(long distribuidorId){		
		return this.servicioListarCargas.listar(distribuidorId);
	}
}
