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
	
	public void crear(Carga carga,Distribuidor distribuidor) {	
		ServicioCargaValidarCumpleanios validarCumpleanios = new ServicioCargaValidarCumpleanios(carga, distribuidor);		
		carga = validarCumpleanios.ejecutar();
		System.out.println(carga.getPrecio());
		
		ServicioCargaValidarEstado validarEstado = new ServicioCargaValidarEstado(carga);
		carga = validarEstado.ejecutar();
		this.repositorioCarga.save(carga);
	}		
}
