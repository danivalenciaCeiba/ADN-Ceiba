package com.ceiba.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCarga {
	
	private long distribuidor_id;
	private double peso;
	private String descripcion;
	private int estado;
	private double precio;	
	
}
