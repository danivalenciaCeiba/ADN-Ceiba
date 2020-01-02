package com.ceiba.dominio.servicio.dao;

import com.ceiba.dominio.exception.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.dao.DistribuidorDao;

public class ServicioDistribuidorDao {
	private static final String El_DISTRIBUIDOR_NO_HA_SIDO_ENCONTRADO = "El distribuidor no ha sido encontrado";
	private DistribuidorDao distribuidorDao;
	
	public ServicioDistribuidorDao(DistribuidorDao distribuidorDao) {
		this.distribuidorDao = distribuidorDao;
	}
	
	public Distribuidor obtenerPorId(long id){
		Distribuidor distribuidor = this.distribuidorDao.findById(id);
		if(null == distribuidor) {
			throw new ExcepcionDuplicidad(El_DISTRIBUIDOR_NO_HA_SIDO_ENCONTRADO+":"+id);
		}
		
		return distribuidor;
	}	
}
