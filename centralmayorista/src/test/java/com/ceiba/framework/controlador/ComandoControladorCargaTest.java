package com.ceiba.framework.controlador;

/*
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
		ComandoCarga comandoCarga = new ComandoCargaTestDataBuilder().build();		
		ComandoControladorDistribuidorTest comandoDistribuidor = new ComandoControladorDistribuidorTest();
		
		//act - assert	
		this.mockMvc.when(comandoDistribuidor.shouldReturnDefaultMessage())
        .thenReturn(true);
	    this.mockMvc.perform(post("/api/v1/cargas").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoCarga))).andDo(print()).andExpect(status().isCreated());
	  }*/
    
}
