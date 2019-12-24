package com.ceiba.puerto.repositorio;

import java.io.Serializable;
import org.springframework.stereotype.Repository;

import com.ceiba.modelo.entidad.Distribuidor;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RepositorioDistribuidor extends JpaRepository<Distribuidor, Serializable>{
	public Distribuidor crear(Distribuidor distribuidor);
	public Distribuidor actualizar(Distribuidor distribuidor);
	public Distribuidor buscarPorNit(String nit);
}
