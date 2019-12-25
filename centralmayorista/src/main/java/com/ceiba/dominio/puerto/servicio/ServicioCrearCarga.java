package com.ceiba.dominio.puerto.servicio;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.puerto.repositorio.RepositorioCarga;

public class ServicioCrearCarga {
private RepositorioCarga repositorioCarga;
	
	public ServicioCrearCarga(RepositorioCarga repositorioCarga) {
		this.repositorioCarga = repositorioCarga;
	}
	
	public void crear(Carga carga) {		
		this.repositorioCarga.save(carga);
	}
}
