package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;

public class CargaDataBuilder {
	private Distribuidor distribuidor;
	private Double peso;
	private String descripcion;
	private Integer estado;
	private Double precio;
	
	
	public CargaDataBuilder() {
		this.peso = 2000.0;
		this.descripcion = "Primera carga del mes";
		this.estado = 1;
		this.precio = 500000.0;
	}	
	
	public CargaDataBuilder conPeso(Double peso) {
		this.peso = peso;
		return this;
	}
	
	public CargaDataBuilder conEstado(Integer estado) {
		this.estado = estado;
		return this;
	}
	
	public CargaDataBuilder conPrecio(Double precio) {
		this.precio = precio;
		return this;
	}
	
	public Carga build() {
		return new Carga(peso,descripcion,estado,precio,distribuidor);
	}
}
