package com.ceiba.dominio.puerto.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.entidad.Carga;

@Repository
public interface RepositorioCarga extends JpaRepository<Carga, Serializable>{
	public Carga save(Carga carga);
}
