package com.ceiba.framework.testdatabuilder;

import com.ceiba.aplicacion.comando.ComandoCarga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;

public class ComandoCargaTestDataBuilder {
	private Distribuidor distribuidor;
	private Long distribuidorId;
	private double peso;
	private String descripcion;
	private int estado;
	private double precio;
	
	
	public ComandoCargaTestDataBuilder() {
		this.distribuidorId = 1L;
		this.peso = 2000;
		this.descripcion = "Primera carga del mes";
		this.estado = 1;
		this.precio = 500000;
	}
	
	public ComandoCargaTestDataBuilder conPeso(double peso) {
		this.peso = peso;
		return this;
	}
	
	public ComandoCargaTestDataBuilder conEstado(int estado) {
		this.estado = estado;
		return this;
	}
	
	public ComandoCargaTestDataBuilder conPrecio(double precio) {
		this.precio = precio;
		return this;
	}
	
	public ComandoCargaTestDataBuilder conDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
		return this;
	}
	
	public ComandoCarga build() {
		return new ComandoCarga(distribuidor,distribuidorId,peso,descripcion,estado,precio);
	}
}
