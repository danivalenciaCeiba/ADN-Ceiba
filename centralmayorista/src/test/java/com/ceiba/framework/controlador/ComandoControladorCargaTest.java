package com.ceiba.framework.controlador;
/*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.aplicacion.comando.ComandoCarga;
import com.ceiba.aplicacion.comando.ComandoDistribuidor;
import com.ceiba.aplicacion.comando.centralmayorista.CentralMayoristaDistribuidor;
import com.ceiba.aplicacion.comando.manejador.ManejadorCrearDistribuidor;
import com.ceiba.dominio.modelo.entidad.Distribuidor;
import com.ceiba.framework.testdatabuilder.ComandoCargaTestDataBuilder;
import com.ceiba.framework.testdatabuilder.ComandoDistribuidorTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc*/
public class ComandoControladorCargaTest {
	/*
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;	
	
	@Before
	public void setUp(){
	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	  public void shouldStoreADistribuidor() throws Exception {
		//Arrange		
		ComandoDistribuidor comandoDistribuidor = new ComandoDistribuidorTestDataBuilder().build();
		
		//act - assert
		this.mockMvc.perform(post("/api/v1/distribuidores").contentType(MediaType.APPLICATION_JSON_UTF8)
              .content(objectMapper.writeValueAsString(comandoDistribuidor))).andDo(print()).andExpect(status().isCreated());	    
	  }
	
	@Test
	  public void shouldReturnDefaultMessage() throws Exception {
		//Arrange
		ComandoCargaTestDataBuilder comandoCargaTestDataBuilder = new ComandoCargaTestDataBuilder();
		ComandoDistribuidor comandoDistribuidor = new ComandoDistribuidorTestDataBuilder().build();
		Distribuidor distribuidor = new CentralMayoristaDistribuidor().crear(comandoDistribuidor);
		comandoCargaTestDataBuilder.conDistribuidor(distribuidor);
		ComandoCarga comandoCarga = new ComandoCargaTestDataBuilder().build();		
		
		//act - assert	
		comandoDistribuidor.shouldReturnDefaultMessage();
		
	    this.mockMvc.perform(post("/api/v1/cargas").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoCarga))).andDo(print()).andExpect(status().isCreated());
	  }
    */
}
