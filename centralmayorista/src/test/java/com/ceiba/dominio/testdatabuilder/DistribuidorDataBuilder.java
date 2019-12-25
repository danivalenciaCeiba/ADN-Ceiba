package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.entidad.Distribuidor;

public class DistribuidorDataBuilder {
	private String nit;	
	private String nombre;		
	private String ciudad;			
	private String cumpleanios;
	
	
	public DistribuidorDataBuilder() {
		this.nit = "1109296986";
		this.nombre = "Daniel Mauricio Valencia Gómez";
		this.ciudad = "Manizales";
		this.cumpleanios = "2019-01-25";
	}
	
	public DistribuidorDataBuilder conNit(String nit) {
		this.nit = nit;
		return this;
	}
	
	public DistribuidorDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public DistribuidorDataBuilder conCumpleanios(String cumpleanios) {
		this.cumpleanios = cumpleanios;
		return this;
	}
	
	public Distribuidor build() {
		return new Distribuidor(nit,nombre,ciudad,cumpleanios);
	}
}
