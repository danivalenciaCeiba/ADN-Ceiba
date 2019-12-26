package com.ceiba.dominio.puerto.servicio.dao;

import java.util.List;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.puerto.dao.CargaDao;

public class ServicioCargaDao {
	private CargaDao cargaDao;
	
	public ServicioCargaDao(CargaDao cargaDao) {
		this.cargaDao = cargaDao;
	}
	
	public List<Carga> listar(long distribuidorId){
		return this.cargaDao.findByDistribuidorId(distribuidorId);
	}
}
