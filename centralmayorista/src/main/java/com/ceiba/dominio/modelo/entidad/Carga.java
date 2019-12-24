package com.ceiba.dominio.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name="cargas")
@Getter
public class Carga {
	private static final String EL_PESO_ES_UN_DATO_OBLIGATORIO = "El peso es un dato obligatorio.";
	private static final String LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO = "La descripción es un dato obligatorio.";
	private static final String EL_PRECIO_ES_UN_DATO_OBLIGATORIO = "El precio es un dato obligatorio.";
	private static final String EL_PRECIO_DEBE_SER_MAYOR_CERO = "El precio debe ser mayor a cero.";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "peso", nullable = false)
	private double peso;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado", nullable = false)
	private int estado = 1;
	
	@Column(name = "precio", nullable = false)
	private double precio;
	
	public Carga(double peso,String descripcion,int estado, double precio) {
		ValidadorArgumento.validarObligatorio(peso, EL_PESO_ES_UN_DATO_OBLIGATORIO);				
		ValidadorArgumento.validarObligatorio(descripcion, LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(precio, EL_PRECIO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarMayorCero(precio, EL_PRECIO_DEBE_SER_MAYOR_CERO);
		
		this.peso = peso;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
	}
}
