package com.ceiba.dominio.puerto.servicio;

import com.ceiba.dominio.exception.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.repositorio.RepositorioDistribuidor;

public class ServicioCrearDistribuidor {
	private static final String El_DISTRIBUIDOR_YA_EXISTE_EN_EL_SISTEMA = "El distribuidor ya existe en el sistema";
	private RepositorioDistribuidor repositorioDistribuidor;
	
	public ServicioCrearDistribuidor(RepositorioDistribuidor repositorioDistribuidor) {
		this.repositorioDistribuidor = repositorioDistribuidor;
	}
	
	public void crear(Distribuidor distribuidor) {
		buscarPorNit(distribuidor.getNit());
		this.repositorioDistribuidor.save(distribuidor);
	}
	
	private void buscarPorNit(String nit) {
		Distribuidor distribuidor = this.repositorioDistribuidor.findByNit(nit);
		if(null != distribuidor) {
			throw new ExcepcionDuplicidad(El_DISTRIBUIDOR_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
