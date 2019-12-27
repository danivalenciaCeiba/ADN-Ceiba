package com.ceiba.dominio.modelo.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.servicio.ServicioCargaValidarCumpleanios;
import com.ceiba.dominio.testdatabuilder.CargaDataBuilder;
import com.ceiba.dominio.testdatabuilder.DistribuidorDataBuilder;

public class ServicioCargaValidarCumpleaniosTest {
	
	private CargaDataBuilder cargaDataBuilder;
	private DistribuidorDataBuilder distribuidorDataBuilder;
	private ServicioCargaValidarCumpleanios servicioCargaValidarCumpleanios;
	
	/**
	 * Se aumenta un 50% al precio de la carga porque la fecha actual y la fecha de cumpleanios del distribuidor son iguales
	 * 
	 */
	@Test
	public void aumentarPrecioCarga() {
		//Arrange 
		this.cargaDataBuilder = new CargaDataBuilder();
		this.distribuidorDataBuilder = new DistribuidorDataBuilder();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");  		
		String fechaActualString = formateador.format(LocalDate.now());
		this.distribuidorDataBuilder.conCumpleanios(fechaActualString);
		Carga carga = this.cargaDataBuilder.build();		
		Distribuidor distribuidor = this.distribuidorDataBuilder.build();
		this.servicioCargaValidarCumpleanios = new ServicioCargaValidarCumpleanios(carga, distribuidor);		
		//precio esperado
		double precioCarga = carga.getPrecio();
		double porcentaje = precioCarga * 0.5;
		double precioEsperado = precioCarga + porcentaje;
		
		//Act
		this.servicioCargaValidarCumpleanios.ejecutar();
		
		//Assert
	    assertEquals(precioEsperado,this.servicioCargaValidarCumpleanios.getCarga().getPrecio());
	}
	
	/**
	 * El precio de la carga no cambia porque la fecha actual y la fecha de cumpleanios del distribuidor no coinciden
	 * 
	 */
	@Test
	public void precioCargaSinCambios() {
		//Arrange 
		this.cargaDataBuilder = new CargaDataBuilder();
		this.distribuidorDataBuilder = new DistribuidorDataBuilder();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");  		
		String fecha = formateador.format(LocalDate.now().plusDays(1));
		this.distribuidorDataBuilder.conCumpleanios(fecha);
		Carga carga = this.cargaDataBuilder.build();
		double precioEsperado = carga.getPrecio();
		Distribuidor distribuidor = this.distribuidorDataBuilder.build();
		this.servicioCargaValidarCumpleanios = new ServicioCargaValidarCumpleanios(carga, distribuidor);
		
		//Act
		this.servicioCargaValidarCumpleanios.ejecutar();
		
		//Assert
	    assertEquals(precioEsperado,this.servicioCargaValidarCumpleanios.getCarga().getPrecio());
	}

}
