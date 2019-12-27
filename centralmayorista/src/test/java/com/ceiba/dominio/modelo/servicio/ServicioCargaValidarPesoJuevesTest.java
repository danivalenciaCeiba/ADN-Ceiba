package com.ceiba.dominio.modelo.servicio;


import java.time.LocalDate;

import org.junit.Test;
import static org.junit.Assert.*;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.servicio.ServicioCargaValidarPesoJueves;
import com.ceiba.dominio.testdatabuilder.CargaDataBuilder;

public class ServicioCargaValidarPesoJuevesTest {
	private ServicioCargaValidarPesoJueves servicioCargaValidarPesoJueves;
	private CargaDataBuilder cargaDataBuilder;
	
	/**
	 * Retorna true porque la carga es mayor a 3000 y la fecha corresponde a un jueves
	 * 
	 */
	@Test
	public void trueEsperado() {
		//Arrange		
		this.cargaDataBuilder = new CargaDataBuilder();
		this.cargaDataBuilder.conPeso(3000.0);
		Carga carga = this.cargaDataBuilder.build();
		this.servicioCargaValidarPesoJueves = new ServicioCargaValidarPesoJueves(carga);
		LocalDate fecha = LocalDate.parse("2019-12-26");
		
		//Act
		boolean respuesta = this.servicioCargaValidarPesoJueves.ejecutar(fecha,2000.0,"THURSDAY");
		
		//Assert
		assertTrue(respuesta);
	}
	
	/**
	 * Retorna false porque la carga es igual a 2000 y la fecha no corresponde a un jueves
	 * 
	 */
	@Test
	public void falseEsperado() {
		//Arrange		
		this.cargaDataBuilder = new CargaDataBuilder();
		this.cargaDataBuilder.conPeso(2000.0);
		Carga carga = this.cargaDataBuilder.build();
		this.servicioCargaValidarPesoJueves = new ServicioCargaValidarPesoJueves(carga);
		LocalDate fecha = LocalDate.parse("2019-12-27");
		
		//Act
		boolean respuesta = this.servicioCargaValidarPesoJueves.ejecutar(fecha,2000.0,"THURSDAY");
		
		//Assert
		assertFalse(respuesta);
	}

}
