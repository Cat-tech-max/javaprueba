package com.pruebas.ejercicio;

import com.pruebas.ejercicio.dto.SearchDTO;
import com.pruebas.ejercicio.model.Prices;
import com.pruebas.ejercicio.service.PricesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EjercicioApplicationTests {
	private static final Logger LOGGER = LogManager.getLogger(EjercicioApplicationTests.class);
	private MockMvc mockMvc;

	@BeforeEach
	public void setup(WebApplicationContext wac) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Mock
	private PricesService servicio;

	private SearchDTO paramsSearch(String brand, String producto, String peticion){
		SearchDTO entidad = new SearchDTO();
		entidad.setId(brand);
		entidad.setProduct(producto);
		entidad.setFecha(peticion);
		return entidad;
	}

	private void mostrarDebug(String test, String res){
		LOGGER.info("Test "+test +" Resultados "+res);
	}

	private void ejecutarVerificar(SearchDTO entidad, List<Prices> res) throws Exception {
		mockMvc.perform(get("/prices/getInfo")
						.param("id", entidad.getId())
						.param("product", entidad.getProduct())
						.param("fecha", entidad.getFecha())
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(result -> {
					assertEquals(res.toString(), result.getResponse().getContentAsString());
				});
	}

	@Test
	public void test1() throws Exception {
		/*
		- Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		 */
		SearchDTO entidad = paramsSearch("1","35455","2020-06-14 10:00:00");
		List<Prices> res = new ArrayList<>();
		Mockito.when(servicio.obtenerPrecios(entidad)).thenReturn(res);
		mostrarDebug("Test1 ",res.toString());
		// Ejecutar y verificar Test1
		ejecutarVerificar(entidad, res);
	}

	@Test
	public void test2() throws Exception {
		/*
		- Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		 */
		SearchDTO entidad = paramsSearch("1","35455","2020-06-14 16:00:00");
		List<Prices> res = new ArrayList<>();
		Mockito.when(servicio.obtenerPrecios(entidad)).thenReturn(res);
		mostrarDebug("Test2 ",res.toString());
		// Ejecutar y verificar Test2
		ejecutarVerificar(entidad, res);
	}

	@Test
	public void test3() throws Exception {
		/*
		- Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		 */
		SearchDTO entidad = paramsSearch("1","35455", "2020-06-14 21:00:00");
		List<Prices> res = new ArrayList<>();
		Mockito.when(servicio.obtenerPrecios(entidad)).thenReturn(res);
		mostrarDebug("Test3 ",res.toString());
		// Ejecutar y verificar Test3
		ejecutarVerificar(entidad, res);
	}

	@Test
	public void test4() throws Exception {
		/*
		- Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
		 */
		SearchDTO entidad = paramsSearch("1","35455", "2020-06-15 10:00:00");
		List<Prices> res = new ArrayList<>();
		Mockito.when(servicio.obtenerPrecios(entidad)).thenReturn(res);
		mostrarDebug("Test4 ",res.toString());
		// Ejecutar y verificar Test4
		ejecutarVerificar(entidad, res);
	}

	@Test
	public void test5() throws Exception {
		/*
		- Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
		 */
		SearchDTO entidad = paramsSearch("1","35455","2020-06-16 21:00:00");
		List<Prices> res = new ArrayList<>();
		Mockito.when(servicio.obtenerPrecios(entidad)).thenReturn(res);
		mostrarDebug("Test5 ",res.toString());
		// Ejecutar y verificar Test5
		ejecutarVerificar(entidad, res);
	}
}
