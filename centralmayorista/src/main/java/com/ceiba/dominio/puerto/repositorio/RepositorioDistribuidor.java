package com.ceiba.dominio.puerto.repositorio;



import java.io.Serializable;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.entidad.Distribuidor;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RepositorioDistribuidor extends JpaRepository<Distribuidor, Serializable>{
	public Distribuidor save(Distribuidor distribuidor);
	//public void actualizar(Distribuidor distribuidor);
	public Distribuidor findByNit(String nit);
	public Distribuidor findById(long id);
}
