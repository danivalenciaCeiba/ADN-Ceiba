package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.entidad.Carga;

public class CargaDataBuilder {
	private Long distribuidor_id;
	private Double peso;
	private String descripcion;
	private Integer estado;
	private Double precio;
	
	
	public CargaDataBuilder() {
		this.distribuidor_id = 1L;
		this.peso = 2000.0;
		this.descripcion = "Primera carga del mes";
		this.estado = 1;
		this.precio = 500000.0;
	}
	
	public CargaDataBuilder conDistribuidorId(Long distribuidor_id) {
		this.distribuidor_id = distribuidor_id;
		return this;
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
		return new Carga(distribuidor_id,peso,descripcion,estado,precio);
	}
}
