package com.ceiba.dominio.servicio;

import com.ceiba.dominio.exception.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.repositorio.RepositorioDistribuidor;

public class ServicioDistribuidor {
	private static final String El_DISTRIBUIDOR_YA_EXISTE_EN_EL_SISTEMA = "El distribuidor ya existe en el sistema";
	private RepositorioDistribuidor repositorioDistribuidor;
	
	public ServicioDistribuidor(RepositorioDistribuidor repositorioDistribuidor) {
		this.repositorioDistribuidor = repositorioDistribuidor;
	}
	
	public Distribuidor crear(Distribuidor distribuidor) {
		buscarPorNit(distribuidor.getNit());
		return this.repositorioDistribuidor.save(distribuidor);
	}
	
	/**
	 * Busca un distribuidor por su nit
	 * 
	 * @param nit nit para buscar el distribuidor
	 */
	private void buscarPorNit(String nit) {
		Distribuidor distribuidor = this.repositorioDistribuidor.findByNit(nit);
		if(null != distribuidor) {
			throw new ExcepcionDuplicidad(El_DISTRIBUIDOR_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
