package com.ceiba.dominio.servicio;

import java.time.LocalDate;

import com.ceiba.dominio.modelo.entidad.Carga;

public class ServicioCargaValidarPesoLimiteEnDiaEspecifico {
	private Carga carga;
	public ServicioCargaValidarPesoLimiteEnDiaEspecifico(Carga carga) {
		this.carga = carga;
	}
	
	/**
	 * Valida si el peso de la carga es mayor a un peso especifico y si la fecha corresponde a un dia especifico
	 * 
	 * @param date Fecha a ser evaluada	 	
	 */
	public boolean ejecutar(LocalDate date,Double pesoLimite, String nombreDia) {
		Double peso = this.carga.getPeso();
		String dayName = date.getDayOfWeek().name();		
		return pesoLimite < peso && dayName.equals(nombreDia);
	}
}
