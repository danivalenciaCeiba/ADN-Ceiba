package com.ceiba.comando.centralmayorista;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoDistribuidor;
import com.ceiba.modelo.entidad.Distribuidor;

@Component
public class CentralMayoristaDistribuidor {
	public Distribuidor crear(ComandoDistribuidor comandoDistribuidor) {
		return new Distribuidor(comandoDistribuidor.getNit(), comandoDistribuidor.getNombre(), comandoDistribuidor.getCiudad(), comandoDistribuidor.getCumpleanios());
	}
}
