package com.ceiba.framework.testdatabuilder;

import com.ceiba.aplicacion.comando.ComandoDistribuidor;

public class ComandoDistribuidorTestDataBuilder {
	private String nit;	
	private String nombre;		
	private String ciudad;			
	private String cumpleanios;
	
	
	public ComandoDistribuidorTestDataBuilder() {
		this.nit = "1109296986";
		this.nombre = "Daniel Mauricio Valencia Gómez";
		this.ciudad = "Manizales";
		this.cumpleanios = "2019-01-25";
	}
	
	public ComandoDistribuidorTestDataBuilder conNit(String nit) {
		this.nit = nit;
		return this;
	}
	
	public ComandoDistribuidorTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ComandoDistribuidorTestDataBuilder conCumpleanios(String cumpleanios) {
		this.cumpleanios = cumpleanios;
		return this;
	}
	
	public ComandoDistribuidor build() {
		return new ComandoDistribuidor(nit,nombre,ciudad,cumpleanios);
	}
}
