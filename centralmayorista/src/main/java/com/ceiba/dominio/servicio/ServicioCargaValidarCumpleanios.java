package com.ceiba.dominio.servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;

public class ServicioCargaValidarCumpleanios {
	private Carga carga;
	private Distribuidor distribuidor;
	
	public ServicioCargaValidarCumpleanios(Carga carga,Distribuidor distribuidor) {
		this.carga = carga;
		this.distribuidor = distribuidor;
	}
	
	/**
	 * Suma el 50% al precio de la carga si el dia actual es el cumpleanos del distribuidor
	 * 
	 * 
	 */
	public Carga ejecutar() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM-dd");  
		LocalDate now = LocalDate.now();
		String fechaActual = formateador.format(now);
		LocalDate cumpleaniosDistribuidorDate = LocalDate.parse(this.distribuidor.getCumpleanios());
		String cumpleaniosDistribuidorString = formateador.format(cumpleaniosDistribuidorDate);
		if(fechaActual.equals(cumpleaniosDistribuidorString)) {
			double precioCarga = this.carga.getPrecio();
			double porcentaje = precioCarga * 0.5;
			this.carga.setPrecio(precioCarga + porcentaje);			
		}
		return this.carga;
	}
}
