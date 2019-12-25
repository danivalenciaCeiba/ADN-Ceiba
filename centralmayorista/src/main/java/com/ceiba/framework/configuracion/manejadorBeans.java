package com.ceiba.framework.configuracion;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.puerto.repositorio.RepositorioCarga;
import com.ceiba.dominio.puerto.repositorio.RepositorioDistribuidor;
import com.ceiba.dominio.puerto.servicio.ServicioCrearCarga;
import com.ceiba.dominio.puerto.servicio.ServicioCrearDistribuidor;


@Configuration
public class manejadorBeans {
	
	@Bean
	public ServicioCrearCarga servicioCrearCarga(RepositorioCarga repositorioCarga){
		return new ServicioCrearCarga(repositorioCarga);
	}
	
	@Bean
	public ServicioCrearDistribuidor servicioCrearDistribuidor(RepositorioDistribuidor repositorioDistribuidor){
		return new ServicioCrearDistribuidor(repositorioDistribuidor);
	}
}
