package com.ceiba.framework.configuracion;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.puerto.dao.CargaDao;
import com.ceiba.dominio.puerto.dao.DistribuidorDao;
import com.ceiba.dominio.puerto.repositorio.RepositorioCarga;
import com.ceiba.dominio.puerto.repositorio.RepositorioDistribuidor;
import com.ceiba.dominio.servicio.ServicioGuardarCarga;
import com.ceiba.dominio.servicio.ServicioGuardarDistribuidor;
import com.ceiba.dominio.servicio.dao.ServicioCargaDao;
import com.ceiba.dominio.servicio.dao.ServicioDistribuidorDao;
import com.ceiba.framework.servicio.trm.TCRMTestClient;


@Configuration
public class ManejadorBeans {
	
	@Bean
	public ServicioGuardarCarga servicioCrearCarga(RepositorioCarga repositorioCarga){
		return new ServicioGuardarCarga(repositorioCarga);
	}
	
	@Bean
	public ServicioGuardarDistribuidor servicioCrearDistribuidor(RepositorioDistribuidor repositorioDistribuidor){
		return new ServicioGuardarDistribuidor(repositorioDistribuidor);
	}
	
	@Bean
	public ServicioCargaDao servicioCargaDao(CargaDao cargaDao){
		return new ServicioCargaDao(cargaDao);
	}
	
	@Bean
	public ServicioDistribuidorDao servicioDistribuidorDao(DistribuidorDao distribuidorDao){
		return new ServicioDistribuidorDao(distribuidorDao);
	}
	
	@Bean
	public TCRMTestClient tcrmTestClient(){
		return new TCRMTestClient();
	}
}
