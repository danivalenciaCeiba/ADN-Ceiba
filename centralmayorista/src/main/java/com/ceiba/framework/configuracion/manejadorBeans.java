package com.ceiba.framework.configuracion;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaDistribuidor;
import com.ceiba.aplicacion.comando.manejador.ManejadorCrearDistribuidor;
import com.ceiba.dominio.puerto.repositorio.RepositorioDistribuidor;
import com.ceiba.dominio.puerto.servicio.ServicioCrearDistribuidor;


@Configuration
public class manejadorBeans {
	
	/*@Bean
	public ManejadorCrearDistribuidor manejadorCrearDistribuidor(ServicioCrearDistribuidor servicioCrearDistribuidor, CentralMayoristaDistribuidor centralMayoristaDistribuidor){
		return new ManejadorCrearDistribuidor(servicioCrearDistribuidor,centralMayoristaDistribuidor);
	}*/
	
	@Bean
	public ServicioCrearDistribuidor servicioCrearDistribuidor(RepositorioDistribuidor repositorioDistribuidor){
		return new ServicioCrearDistribuidor(repositorioDistribuidor);
	}
}
