package com.ceiba.dominio.puerto.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.entidad.Distribuidor;

@Repository
public interface DistribuidorDao extends JpaRepository<Distribuidor, Serializable> {
	public Distribuidor findById(long id);
}
