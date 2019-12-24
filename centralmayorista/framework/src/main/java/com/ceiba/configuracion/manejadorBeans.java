package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.puerto.repositorio.RepositorioDistribuidor;
import com.ceiba.puerto.servicio.ServicioCrearDistribuidor;

@Configuration
public class manejadorBeans {
	@Bean
	public ServicioCrearDistribuidor servicioCrearDistribuidor(RepositorioDistribuidor repositorioDistribuidor){
		return new ServicioCrearDistribuidor(repositorioDistribuidor);
	}
}
