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
		validarCumpleanios(carga, distribuidor);
		validarEstado(carga);
		this.repositorioCarga.save(carga);
	}	
	
	/**
	 * Suma el 50% al precio de la carga si el dia actual es el cumpleanos del distribuidor
	 * 
	 * @param carga Carga que va a ser almacenada
	 * @param distribuidor Distribuidor al cual la carga sera asociada
	 */
	public void validarCumpleanios(Carga carga, Distribuidor distribuidor) {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM-dd");  
		LocalDate now = LocalDate.now();
		String fechaActual = formateador.format(now);
		LocalDate cumpleaniosDistribuidorDate = LocalDate.parse(distribuidor.getCumpleanios());
		String cumpleaniosDistribuidorString = formateador.format(cumpleaniosDistribuidorDate);
		if(fechaActual.equals(cumpleaniosDistribuidorString)) {
			double precioCarga = carga.getPrecio();
			double porcentaje = precioCarga * 0.5;
			carga.setPrecio(precioCarga + porcentaje);		
			System.out.println(carga.getPrecio());
		}
	}
	
	/**
	 * Resta el 10% al precio de la carga si esta se encuentra en mal estado
	 * 
	 * @param carga Carga que va a ser almacenada	 
	 */
	public void validarEstado(Carga carga) {
		int estado = carga.getEstado();
		if(2 == estado) {
			double precioCarga = carga.getPrecio();
			double porcentaje = precioCarga * 0.1;
			carga.setPrecio(precioCarga - porcentaje);		
			System.out.println(carga.getPrecio());
		}
	}
}
