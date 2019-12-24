package com.ceiba.aplicacion.comando.centralmayorista;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoDistribuidor;
import com.ceiba.dominio.modelo.entidad.Distribuidor;

@Component
public class CentralMayoristaDistribuidor {
	public Distribuidor crear(ComandoDistribuidor comandoDistribuidor) {
		return new Distribuidor(comandoDistribuidor.getNit(), comandoDistribuidor.getNombre(), comandoDistribuidor.getCiudad(), comandoDistribuidor.getCumpleanios());
	}
}
