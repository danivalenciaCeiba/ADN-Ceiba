package com.ceiba.dominio.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="cargas")
@Getter
@Setter
public class Carga {
	private static final String EL_PESO_ES_UN_DATO_OBLIGATORIO = "El peso es un dato obligatorio.";
	private static final String LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO = "La descripcion es un dato obligatorio.";
	private static final String EL_PRECIO_ES_UN_DATO_OBLIGATORIO = "El precio es un dato obligatorio.";
	private static final String EL_PRECIO_DEBE_SER_MAYOR_CERO = "El precio debe ser mayor a cero.";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "distribuidor_id")
	@JsonIgnore
	private Distribuidor distribuidor;
	
	@Column(name = "peso", nullable = false)
	private Double peso;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado", nullable = false)
	private Integer estado = 1;
	
	@Column(name = "precio", nullable = false)
	private double precio;
	
	public Carga() {		
	}
	
	public Carga(Double peso,String descripcion,Integer estado, Double precio,Distribuidor distribuidor) {
		ValidadorArgumento.validarObligatorio(peso, EL_PESO_ES_UN_DATO_OBLIGATORIO);				
		ValidadorArgumento.validarObligatorio(descripcion, LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(precio, EL_PRECIO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarMayorCero(precio, EL_PRECIO_DEBE_SER_MAYOR_CERO);
		
		this.peso = peso;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
		this.distribuidor = distribuidor;
	}
}
