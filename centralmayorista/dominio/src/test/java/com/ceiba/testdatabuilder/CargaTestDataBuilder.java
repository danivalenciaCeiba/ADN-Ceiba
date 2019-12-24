package com.ceiba.testdatabuilder;

import com.ceiba.modelo.entidad.Carga;

public class CargaTestDataBuilder {
	private double peso;
	private String descripcion;
	private int estado = 1;
	private double precio;
	
	public CargaTestDataBuilder() {
		this.peso = 1000.00;
		this.descripcion = "Primera carga del mes";
		this.estado = 1;
		this.precio = 200000.00;
	}
	
	/**
	 * Modifica el atributo peso
	 * 
	 * @param peso valor por el que va a ser modificado el peso
	 * @return CargaTestDataBuilder
	 */
	
	public CargaTestDataBuilder cambiarPeso(double peso) {
		this.peso = peso;
		return this;
	}
	
	/**
	 * Modifica el atributo descripcion
	 * 
	 * @param descripcion valor por el que va a ser modificado el descripcion
	 * @return CargaTestDataBuilder
	 */
	
	public CargaTestDataBuilder cambiarDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	/**
	 * Modifica el atributo precio
	 * 
	 * @param precio valor por el que va a ser modificado el precio
	 * @return CargaTestDataBuilder
	 */
	
	public CargaTestDataBuilder cambiarPrecio(double precio) {
		this.precio = precio;
		return this;
	}
	
	/**
	 * Construye un objeto de tipo Carga con los atributos modificados
	 * 
	 * @return Carga
	 */
	public Carga build() {
		return new Carga(peso,descripcion,estado,precio);
	}
}
