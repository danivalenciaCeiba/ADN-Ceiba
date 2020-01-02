package com.ceiba.aplicacion.comando;

import com.ceiba.dominio.modelo.entidad.Distribuidor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCarga {
	private Distribuidor distribuidor;
	private long distribuidorId;
	private double peso;
	private String descripcion;
	private int estado;
	private double precio;	
	
}
