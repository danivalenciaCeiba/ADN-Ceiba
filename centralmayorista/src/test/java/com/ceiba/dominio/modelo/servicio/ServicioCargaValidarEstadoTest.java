package com.ceiba.dominio.modelo.servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.servicio.ServicioCargaValidarEstado;
import com.ceiba.dominio.testdatabuilder.CargaDataBuilder;

public class ServicioCargaValidarEstadoTest {
	
	private CargaDataBuilder cargaDataBuilder;	
	private ServicioCargaValidarEstado servicioCargaValidarEstado;
	
	/**
	 * El precio de la carga disminuye el 10% si el estado es malo (2)
	 * 
	 */
	@Test
	public void disminuirPrecioCarga() {
		//Arrange 
		this.cargaDataBuilder = new CargaDataBuilder();		
		this.cargaDataBuilder.conEstado(2);
		Carga carga = this.cargaDataBuilder.build();		
		this.servicioCargaValidarEstado = new ServicioCargaValidarEstado(carga);	
		
		//precio esperado
		double precioCarga = carga.getPrecio();
		double porcentaje = precioCarga * 0.1;
		double precioEsperado = precioCarga - porcentaje;
		
		//Act
		this.servicioCargaValidarEstado.ejecutar();
		
		//Assert
	    assertEquals(precioEsperado,this.servicioCargaValidarEstado.getCarga().getPrecio());
	}
	
	/**
	 * El precio de la carga no se modifica si el estado es bueno (1)
	 * 
	 */
	@Test
	public void precioCargaSinCambios() {
		//Arrange 
		this.cargaDataBuilder = new CargaDataBuilder();		
		this.cargaDataBuilder.conEstado(1);
		Carga carga = this.cargaDataBuilder.build();		
		this.servicioCargaValidarEstado = new ServicioCargaValidarEstado(carga);	
		
		//precio esperado
		double precioEsperado = carga.getPrecio();
		
		//Act
		this.servicioCargaValidarEstado.ejecutar();
		
		//Assert
	    assertEquals(precioEsperado,this.servicioCargaValidarEstado.getCarga().getPrecio());
	}

}
