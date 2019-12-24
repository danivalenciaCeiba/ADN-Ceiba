package com.ceiba.testdatabuilder;

import com.ceiba.modelo.entidad.Distribuidor;

public class DistribuidorTestDataBuilder {
	private String nit;
	private String nombre;
	private String ciudad;
	private String cumpleanios;
	
	public DistribuidorTestDataBuilder() {
		this.nit = "1109296986";
		this.nombre = "Daniel Mauricio Valencia Gómez";
		this.ciudad = "Fresno";
		this.cumpleanios = "1992-01-25";
	}
		
	/**
	 * Modifica el atributo nit
	 * 
	 * @param nit valor por el que va a ser modificado el nit
	 * @return DistribuidorTestDataBuilder
	 */
	public DistribuidorTestDataBuilder cambiarNit(String nit) {
		this.nit = nit;
		return this;
	}
		
	/**
	 * Modifica el atributo nombre
	 * 
	 * @param nombre valor por el que va a ser modificado el nombre
	 * @return DistribuidorTestDataBuilder
	 */
	public DistribuidorTestDataBuilder cambiarNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	/**
	 * Modifica el atributo cumpleanios
	 * 
	 * @param cumpleanios valor por el que va a ser modificado el cumpleanios
	 * @return DistribuidorTestDataBuilder
	 */
	
	public DistribuidorTestDataBuilder cambiarCumpleanios(String cumpleanios) {
		this.cumpleanios = cumpleanios;
		return this;
	}
	
	/**
	 * Construye un objeto de tipo Distribuidor con los atributos modificados
	 * 
	 * @return Distribuidor
	 */
	public Distribuidor build() {
		return new Distribuidor(nit,nombre,ciudad,cumpleanios);
	}
}
