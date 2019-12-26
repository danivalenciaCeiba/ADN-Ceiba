package com.ceiba.dominio.puerto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;

@Repository
public interface CargaDao extends JpaRepository<Carga, Serializable>{	
	
	public List<Carga> findByDistribuidorId(long distribuidorId);
}
