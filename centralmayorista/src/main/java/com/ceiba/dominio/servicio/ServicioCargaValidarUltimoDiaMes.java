package com.ceiba.dominio.servicio;

import java.time.LocalDate;

public class ServicioCargaValidarUltimoDiaMes {
	
	public ServicioCargaValidarUltimoDiaMes() {
	}
	
	/**
	 * Valida si una fecha corresponde al ultimo dia del mes
	 * 
	 * @param fecha fecha a ser evaluada
	 * @return boolean
	 */
	public boolean ejecutar(LocalDate fecha) {
		LocalDate ultimoDia = fecha.withDayOfMonth(fecha.lengthOfMonth());
		return fecha.equals(ultimoDia);
	}
}
