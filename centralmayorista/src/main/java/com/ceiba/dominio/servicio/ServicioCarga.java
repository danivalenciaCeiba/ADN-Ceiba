package com.ceiba.dominio.servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.repositorio.RepositorioCarga;

public class ServicioCarga {
	private RepositorioCarga repositorioCarga;
	
	public ServicioCarga(RepositorioCarga repositorioCarga) {
		this.repositorioCarga = repositorioCarga;
	}
	
	/**
	 * Aplica las validaciones de negocio y hace el llamado para guardar una carga
	 * 
	 * @param carga Carga que será almacenada
	 * @param distribuidor necesario para aplicar las validaciones
	 */
	public void crear(Carga carga,Distribuidor distribuidor) {	
		ServicioCargaValidarCumpleanios validarCumpleanios = new ServicioCargaValidarCumpleanios(carga, distribuidor);		
		carga = validarCumpleanios.ejecutar();
		
		ServicioCargaValidarEstado validarEstado = new ServicioCargaValidarEstado(carga);
		carga = validarEstado.ejecutar();
		this.repositorioCarga.save(carga);
	}		
}
