package com.ceiba.aplicacion.comando.centralmayorista;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoCarga;
import com.ceiba.dominio.modelo.entidad.Carga;

@Component
public class CentralMayoristaCarga {
	public Carga crear(ComandoCarga comandoCarga) {
		return new Carga(comandoCarga.getDistribuidor(),comandoCarga.getPeso(),comandoCarga.getDescripcion(),comandoCarga.getEstado(),comandoCarga.getPrecio());
	}
}
