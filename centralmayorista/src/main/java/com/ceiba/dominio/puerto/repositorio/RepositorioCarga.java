package com.ceiba.dominio.puerto.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.dominio.modelo.entidad.Carga;

public interface RepositorioCarga extends JpaRepository<Carga, Serializable>{
	public Carga save(Carga carga);
}
