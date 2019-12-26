package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.entidad.Carga;

public class ServicioCargaValidarEstado {
	private Carga carga;
	public ServicioCargaValidarEstado(Carga carga) {
		this.carga = carga;
	}
	
	/**
	 * Resta el 10% al precio de la carga si esta se encuentra en mal estado
	 * 	 	
	 */
	public Carga ejecutar() {
		int estado = this.carga.getEstado();
		if(2 == estado) {
			double precioCarga = this.carga.getPrecio();
			double porcentaje = precioCarga * 0.1;
			this.carga.setPrecio(precioCarga - porcentaje);					
		}
		return this.carga;
	}
}
