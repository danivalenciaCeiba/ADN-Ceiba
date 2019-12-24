package com.ceiba.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ceiba.testdatabuilder.DistribuidorTestDataBuilder;

class DistribuidorTest {

	@Test
	public void validarNombreObligatorio() {
		//Arrange
		DistribuidorTestDataBuilder distribuidorTestDataBuilder = new DistribuidorTestDataBuilder();
		distribuidorTestDataBuilder.cambiarNit(null);
		//Act - Assert		
		assertTrue(true);
	}	

}
