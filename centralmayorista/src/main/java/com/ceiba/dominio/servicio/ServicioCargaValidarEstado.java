package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.entidad.Carga;

import lombok.Getter;

@Getter
public class ServicioCargaValidarEstado {
	private static final int CARGA_EN_MAL_ESTADO = 2;
	private Carga carga;
	private static final double DISMINUCION_PORCENTAJE = 0.1;
	public ServicioCargaValidarEstado(Carga carga) {
		this.carga = carga;
	}
	
	/**
	 * Resta el 10% al precio de la carga si esta se encuentra en mal estado
	 * 	 	
	 */
	public Carga ejecutar() {
		int estado = this.carga.getEstado();
		if(CARGA_EN_MAL_ESTADO == estado) {
			double precioCarga = this.carga.getPrecio();
			double porcentaje = precioCarga * DISMINUCION_PORCENTAJE;
			this.carga.setPrecio(precioCarga - porcentaje);					
		}
		return this.carga;
	}
}
