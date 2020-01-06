package com.ceiba.dominio.servicio;

import java.time.LocalDate;
import com.ceiba.dominio.exception.ExceptionPesoPorDia;
import com.ceiba.dominio.exception.ExceptionUltimoDiaMes;
import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.repositorio.RepositorioCarga;

public class ServicioCarga {
	private static final String ULTIMO_DIA_DEL_MES = "Hoy no se pueden registrar cargas por mantenimiento";
	private static final String NO_MAS_PESO_HOY = "Hoy no se permiten cargas de mas de 2000 kilos";
	private RepositorioCarga repositorioCarga;
	
	public ServicioCarga(RepositorioCarga repositorioCarga) {
		this.repositorioCarga = repositorioCarga;
	}
	
	/**
	 * Aplica las validaciones de negocio y hace el llamado para guardar una carga
	 * 
	 * @param carga Carga que sera almacenada
	 * @param distribuidor necesario para aplicar las validaciones
	 */
	public void crear(Carga carga,Distribuidor distribuidor) {	
		ServicioCargaValidarCumpleanios validarCumpleanios = new ServicioCargaValidarCumpleanios(carga, distribuidor);		
		carga = validarCumpleanios.ejecutar();
		
		ServicioCargaValidarEstado validarEstado = new ServicioCargaValidarEstado(carga);
		carga = validarEstado.ejecutar();
				
		LocalDate fechaActual = LocalDate.now();
		ServicioCargaValidarUltimoDiaMes validarUltimoDiaMes = new ServicioCargaValidarUltimoDiaMes(fechaActual);
		
		ServicioCargaValidarPesoJueves validarPesoJueves = new ServicioCargaValidarPesoJueves(carga);
		
		if(!validarUltimoDiaMes.ejecutar()) {
			if(!validarPesoJueves.ejecutar(fechaActual,2000.0,"THURSDAY")) {
				carga.setDistribuidor(distribuidor);
				this.repositorioCarga.save(carga);
			}else {
				throw new ExceptionPesoPorDia(NO_MAS_PESO_HOY);
			}
		}else {
			throw new ExceptionUltimoDiaMes(ULTIMO_DIA_DEL_MES);
		}
	}		
}
