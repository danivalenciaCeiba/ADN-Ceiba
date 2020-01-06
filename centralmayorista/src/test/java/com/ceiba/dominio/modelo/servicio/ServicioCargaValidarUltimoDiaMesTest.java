package com.ceiba.dominio.modelo.servicio;

import java.time.LocalDate;

import org.junit.Test;
import static org.junit.Assert.*;

import com.ceiba.dominio.servicio.ServicioCargaValidarUltimoDiaMes;

public class ServicioCargaValidarUltimoDiaMesTest {
	private ServicioCargaValidarUltimoDiaMes servicioCargaValidarUltimoDiaMes;

	/**
	 * Retorna true porque se pasa el ultimo dia del mes
	 * 
	 */
	@Test
	public void trueEsperado() {
		//Arrange 				
		LocalDate fechaActual = LocalDate.now();
		LocalDate ultimoDia = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth());
		this.servicioCargaValidarUltimoDiaMes = new ServicioCargaValidarUltimoDiaMes(ultimoDia);
		//Act
		boolean respuesta = this.servicioCargaValidarUltimoDiaMes.ejecutar();
		
		//Assert
		assertTrue(respuesta);
	}
	
	/**
	 * Retorna false porque se pasa un dia que no es el ultimo dia del mes
	 * 
	 */
	@Test
	public void falseEsperado() {
		//Arrange 			
		LocalDate fechaActual = LocalDate.now();
		LocalDate fecha = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth()-1);
		this.servicioCargaValidarUltimoDiaMes = new ServicioCargaValidarUltimoDiaMes(fecha);
		//Act
		boolean respuesta = this.servicioCargaValidarUltimoDiaMes.ejecutar();
		
		//Assert
		assertFalse(respuesta);
	}

}
