package com.ceiba.dominio.modelo;



import org.junit.jupiter.api.Test;

import com.ceiba.CeibaApplicationTests;
import com.ceiba.dominio.exception.ExcepcionLongitudValor;
import com.ceiba.dominio.exception.ExcepcionValorObligatorio;
import com.ceiba.dominio.testdatabuilder.DistribuidorDataBuilder;

class DistribuidorTest {

	@Test
	public void validarNitObligatorio() {
		//Arrange
		DistribuidorDataBuilder distribuidorDataBuilder = new DistribuidorDataBuilder();
		distribuidorDataBuilder.conNit(null);
		//Act - Assert
		CeibaApplicationTests.assertThrows(()-> distribuidorDataBuilder.build(),ExcepcionValorObligatorio.class,"El nit es un dato obligatorio.");
	}
	
	@Test
	public void validarLongitudNit() {
		//Arrange
		DistribuidorDataBuilder distribuidorDataBuilder = new DistribuidorDataBuilder();
		distribuidorDataBuilder.conNit("1109296986256854448454554854");
		//Act - Assert
		CeibaApplicationTests.assertThrows(()-> distribuidorDataBuilder.build(),ExcepcionLongitudValor.class,"El nit debe tener mínimo 20 digitos");
	}
	
	@Test
	public void validarNombreObligatorio() {
		//Arrange
		DistribuidorDataBuilder distribuidorDataBuilder = new DistribuidorDataBuilder();
		distribuidorDataBuilder.conNombre(null);
		//Act - Assert
		CeibaApplicationTests.assertThrows(()-> distribuidorDataBuilder.build(),ExcepcionValorObligatorio.class,"El nombre es un dato obligatorio.");
	}
	
	@Test
	public void validarCumpleaniosObligatorio() {
		//Arrange
		DistribuidorDataBuilder distribuidorDataBuilder = new DistribuidorDataBuilder();
		distribuidorDataBuilder.conCumpleanios(null);
		//Act - Assert
		CeibaApplicationTests.assertThrows(()-> distribuidorDataBuilder.build(),ExcepcionValorObligatorio.class,"La fecha de cumpleanios es un dato obligatorio.");
	}		
}
