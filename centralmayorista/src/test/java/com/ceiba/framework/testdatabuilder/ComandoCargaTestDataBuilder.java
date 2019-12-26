package com.ceiba.framework.testdatabuilder;

import com.ceiba.aplicacion.comando.ComandoCarga;

public class ComandoCargaTestDataBuilder {
	private long distribuidor_id;
	private double peso;
	private String descripcion;
	private int estado;
	private double precio;
	
	
	public ComandoCargaTestDataBuilder() {
		this.distribuidor_id = 1;
		this.peso = 2000;
		this.descripcion = "Primera carga del mes";
		this.estado = 1;
		this.precio = 500000;
	}
	
	public ComandoCargaTestDataBuilder conDistribuidorId(long distribuidor_id) {
		this.distribuidor_id = distribuidor_id;
		return this;
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
	
	public ComandoCarga build() {
		return new ComandoCarga(distribuidor_id,peso,descripcion,estado,precio);
	}
}
