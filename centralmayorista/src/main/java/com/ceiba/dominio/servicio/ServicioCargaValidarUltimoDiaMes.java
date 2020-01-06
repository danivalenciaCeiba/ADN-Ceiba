package com.ceiba.dominio.servicio;

import java.time.LocalDate;

public class ServicioCargaValidarUltimoDiaMes {
	private LocalDate fecha;
	public ServicioCargaValidarUltimoDiaMes(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Valida si una fecha corresponde al ultimo dia del mes
	 * 
	 * @param fecha fecha a ser evaluada
	 * @return boolean
	 */
	public boolean ejecutar() {
		LocalDate ultimoDia = this.fecha.withDayOfMonth(this.fecha.lengthOfMonth());
		return fecha.equals(ultimoDia);
	}
}
