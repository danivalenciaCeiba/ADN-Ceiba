package com.ceiba.dominio.modelo.servicio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ceiba.aplicacion.comando.ComandoDistribuidor;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.testdatabuilder.DistribuidorDataBuilder;


public class ServicioGuardarDistribuidorTest {
	
	/**
	 * Retorna true porque se pasa el ultimo dia del mes
	 * 
	 */
	@Test
	public void trueEsperado() {
		//Arrange 				
		ComandoDistribuidor comandoDistribuidor = new ComandoDistribuidor();
		Distribuidor distribuidor = new DistribuidorDataBuilder().build();
		/*
		comandoDistribuidor.setNit(distribuidor.getNit());
		comandoDistribuidor.setNombre(distribuidor.getNombre());
		comandoDistribuidor.setCiudad(distribuidor.getCiudad());
		comandoDistribuidor.setCumpleanios(distribuidor.getCumpleanios());
		*/


		//Act
		
		
		//Assert
		//assertTrue(respuesta);
	}	

}
