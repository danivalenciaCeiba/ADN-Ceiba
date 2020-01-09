package com.ceiba.dominio.servicio;

import com.ceiba.dominio.exception.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.repositorio.RepositorioDistribuidor;

public class ServicioGuardarDistribuidor {
	private static final String EL_DISTRIBUIDOR_YA_EXISTE_EN_EL_SISTEMA = "El distribuidor ya existe en el sistema";
	private RepositorioDistribuidor repositorioDistribuidor;
	
	public ServicioGuardarDistribuidor(RepositorioDistribuidor repositorioDistribuidor) {
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
			throw new ExcepcionDuplicidad(EL_DISTRIBUIDOR_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
