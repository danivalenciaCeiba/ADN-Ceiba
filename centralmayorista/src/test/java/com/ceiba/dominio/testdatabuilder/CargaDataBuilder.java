package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.entidad.Carga;

public class CargaDataBuilder {
	private long distribuidor_id;
	private double peso;
	private String descripcion;
	private int estado;
	private double precio;
	
	
	public CargaDataBuilder() {
		this.distribuidor_id = 1;
		this.peso = 2000;
		this.descripcion = "Primera carga del mes";
		this.estado = 1;
		this.precio = 500000;
	}
	
	public CargaDataBuilder conDistribuidorId(long distribuidor_id) {
		this.distribuidor_id = distribuidor_id;
		return this;
	}
	
	public CargaDataBuilder conPeso(double peso) {
		this.peso = peso;
		return this;
	}
	
	public CargaDataBuilder conEstado(int estado) {
		this.estado = estado;
		return this;
	}
	
	public CargaDataBuilder conPrecio(double precio) {
		this.precio = precio;
		return this;
	}
	
	public Carga build() {
		return new Carga(distribuidor_id,peso,descripcion,estado,precio);
	}
}
