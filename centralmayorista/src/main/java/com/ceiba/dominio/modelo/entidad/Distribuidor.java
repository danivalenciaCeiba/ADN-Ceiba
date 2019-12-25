package com.ceiba.dominio.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name="distribuidores")
@Getter
public class Distribuidor {
	
	private static final int TAMANO_MAXIMO_NIT = 20;	
	private static final String EL_NIT_DEBE_TENER_MAXIMO_DIGITOS = "El nit debe tener mÃ­nimo %s digitos ";
	private static final String EL_NIT_ES_UN_DATO_OBLIGATORIO = "El nit es un dato obligatorio.";
	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre es un dato obligatorio.";
	private static final String EL_CUMPLEANIOS_ES_UN_DATO_OBLIGATORIO = "La fecha de cumpleaños es un dato obligatorio.";	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nit", nullable = false)
	private String nit;
	
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column(name="ciudad")
	private String ciudad;	
	
	@Column(name="cumpleanios", nullable = false)
	private String cumpleanios;
	
	public Distribuidor() {		
	}
	
	public Distribuidor(String nit,String nombre,String ciudad,String cumpleanios) {
		
		ValidadorArgumento.validarObligatorio(nit, EL_NIT_ES_UN_DATO_OBLIGATORIO);		
		ValidadorArgumento.validarLongitudMaxima(nit, TAMANO_MAXIMO_NIT, String.format(EL_NIT_DEBE_TENER_MAXIMO_DIGITOS,TAMANO_MAXIMO_NIT));
		ValidadorArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(cumpleanios, EL_CUMPLEANIOS_ES_UN_DATO_OBLIGATORIO);		
		
		this.nit = nit;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.cumpleanios = cumpleanios;
	}
}
