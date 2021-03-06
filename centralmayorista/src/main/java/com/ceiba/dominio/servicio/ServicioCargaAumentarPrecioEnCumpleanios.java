package com.ceiba.dominio.servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;

import lombok.Getter;

@Getter
public class ServicioCargaAumentarPrecioEnCumpleanios {
	private Carga carga;
	private Distribuidor distribuidor;
	private LocalDate fechaActual;
	private static final double AUMENTO_PORCENTAJE = 0.5;
	
	public ServicioCargaAumentarPrecioEnCumpleanios(Carga carga,Distribuidor distribuidor) {
		this.carga = carga;
		this.distribuidor = distribuidor;
		this.fechaActual = LocalDate.now();
	}	
	
	/**
	 * Suma el 50% al precio de la carga si el dia actual es el cumpleanos del distribuidor
	 * 
	 * 
	 */
	public Carga ejecutar() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM-dd");  		
		String fechaActualString = formateador.format(this.fechaActual);
		LocalDate cumpleaniosDistribuidorDate = LocalDate.parse(this.distribuidor.getCumpleanios());
		String cumpleaniosDistribuidorString = formateador.format(cumpleaniosDistribuidorDate);
		if(fechaActualString.equals(cumpleaniosDistribuidorString)) {
			double precioCarga = this.carga.getPrecio();
			double porcentaje = precioCarga * AUMENTO_PORCENTAJE;
			this.carga.setPrecio(precioCarga + porcentaje);			
		}
		return this.carga;
	}
}
