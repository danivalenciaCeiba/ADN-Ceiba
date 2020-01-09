package com.ceiba.dominio.servicio;

import java.time.LocalDate;
import com.ceiba.dominio.exception.ExceptionPesoPorDia;
import com.ceiba.dominio.exception.ExceptionUltimoDiaMes;
import com.ceiba.dominio.modelo.entidad.Carga;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.dominio.puerto.repositorio.RepositorioCarga;

public class ServicioGuardarCarga {
	private static final String ULTIMO_DIA_DEL_MES = "Hoy no se pueden registrar cargas por mantenimiento";
	private static final String NO_MAS_PESO_HOY = "Hoy no se permiten cargas de mas de 2000 kilos";
	private static final String NOMBRE_DIA = "THURSDAY";
	private static final double PESO_LIMITE = 2000.0;
	private RepositorioCarga repositorioCarga;
	
	public ServicioGuardarCarga(RepositorioCarga repositorioCarga) {
		this.repositorioCarga = repositorioCarga;
	}
	
	/**
	 * Aplica las validaciones de negocio y hace el llamado para guardar una carga
	 * 
	 * @param carga Carga que sera almacenada
	 * @param distribuidor necesario para aplicar las validaciones
	 */
	public void crear(Carga carga,Distribuidor distribuidor) {	
		ServicioCargaAumentarPrecioEnCumpleanios validarCumpleanios = new ServicioCargaAumentarPrecioEnCumpleanios(carga, distribuidor);		
		carga = validarCumpleanios.ejecutar();
		
		ServicioCargaValidarEstado validarEstado = new ServicioCargaValidarEstado(carga);
		carga = validarEstado.ejecutar();
				
		LocalDate fechaActual = LocalDate.now();
		ServicioCargaValidarUltimoDiaMes validarUltimoDiaMes = new ServicioCargaValidarUltimoDiaMes(fechaActual);
		
		ServicioCargaValidarPesoLimiteEnDiaEspecifico validarPesoJueves = new ServicioCargaValidarPesoLimiteEnDiaEspecifico(carga);
		
		if(!validarUltimoDiaMes.ejecutar()) {
			if(!validarPesoJueves.ejecutar(fechaActual,PESO_LIMITE,NOMBRE_DIA)) {
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
