package com.ceiba.dominio.modelo;

import org.junit.Test;

import com.ceiba.CeibaApplicationTests;
import com.ceiba.dominio.exception.ExcepcionValorObligatorio;
import com.ceiba.dominio.testdatabuilder.CargaDataBuilder;

public class CargaTest {
	
	@Test
	public void validarPesoObligatorio() {
		//Arrange
		CargaDataBuilder cargaDataBuilder = new CargaDataBuilder();
		Double peso = null;
		cargaDataBuilder.conPeso(peso);
		//Act - Assert
		CeibaApplicationTests.assertThrows(()-> cargaDataBuilder.build(),ExcepcionValorObligatorio.class,"El peso es un dato obligatorio.");
	}
	
	@Test
	public void validarPrecioObligatorio() {
		//Arrange
		CargaDataBuilder cargaDataBuilder = new CargaDataBuilder();
		Double precio = null;
		cargaDataBuilder.conPrecio(precio);
		//Act - Assert
		CeibaApplicationTests.assertThrows(()-> cargaDataBuilder.build(),ExcepcionValorObligatorio.class,"El precio es un dato obligatorio.");
	}
		
}
