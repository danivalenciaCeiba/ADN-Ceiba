package com.ceiba.framework.configuracion;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.puerto.dao.CargaDao;
import com.ceiba.dominio.puerto.dao.DistribuidorDao;
import com.ceiba.dominio.puerto.repositorio.RepositorioCarga;
import com.ceiba.dominio.puerto.repositorio.RepositorioDistribuidor;
import com.ceiba.dominio.puerto.servicio.ServicioCarga;
import com.ceiba.dominio.puerto.servicio.dao.ServicioCargaDao;
import com.ceiba.dominio.puerto.servicio.dao.ServicioDistribuidorDao;
import com.ceiba.dominio.puerto.servicio.ServicioDistribuidor;


@Configuration
public class manejadorBeans {
	
	@Bean
	public ServicioCarga servicioCrearCarga(RepositorioCarga repositorioCarga){
		return new ServicioCarga(repositorioCarga);
	}
	
	@Bean
	public ServicioDistribuidor servicioCrearDistribuidor(RepositorioDistribuidor repositorioDistribuidor){
		return new ServicioDistribuidor(repositorioDistribuidor);
	}
	
	@Bean
	public ServicioCargaDao servicioCargaDao(CargaDao cargaDao){
		return new ServicioCargaDao(cargaDao);
	}
	
	@Bean
	public ServicioDistribuidorDao servicioDistribuidorDao(DistribuidorDao distribuidorDao){
		return new ServicioDistribuidorDao(distribuidorDao);
	}
}
