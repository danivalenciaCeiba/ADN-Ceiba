package com.ceiba.framework.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.aplicacion.comando.ComandoDistribuidor;
import com.ceiba.framework.testdatabuilder.ComandoDistribuidorTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ComandoControladorDistribuidor.class)
@ComponentScan("com.ceiba.framework")
public class ComandoControladorDistribuidorTest {
	@Autowired 	
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    /*
    @Test
    public void crear() throws Exception{
        // arrange
        ComandoDistribuidor comandoDistribuidor = new ComandoDistribuidorTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/api/v1/distribuidores")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoDistribuidor)))
        		.andExpect(status().isOk());
    }*/
}
