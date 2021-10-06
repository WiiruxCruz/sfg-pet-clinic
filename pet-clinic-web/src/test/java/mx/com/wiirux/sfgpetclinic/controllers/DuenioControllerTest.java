package mx.com.wiirux.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;

@ExtendWith(MockitoExtension.class)
class DuenioControllerTest {
	
	@Mock
	DuenioService ds;
	
	@InjectMocks
	DuenioController controller;
	
	Set<Duenio> duenios;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		duenios = new HashSet<>();
		duenios.add(Duenio.builder().id(1L).build());
		duenios.add(Duenio.builder().id(2L).build());
		
		mockMvc = MockMvcBuilders
				.standaloneSetup(controller)
				.build();
	}

	/*
	@Test
	void testListaDuenios() throws Exception {
		when(ds.findAll()).thenReturn(duenios);
		
		mockMvc.perform( get("/duenios") )
		.andExpect( status().isOk() )
		.andExpect( view().name("duenios/index") )
		.andExpect( model().attribute("duenios", hasSize(2)) )
		;
	}
	
	@Test
	void testListaPorIndex() throws Exception {
		when(ds.findAll()).thenReturn(duenios);
		
		mockMvc.perform( get("/duenios/index") )
		.andExpect( status().isOk() )
		.andExpect( view().name("duenios/index") )
		.andExpect( model().attribute("duenios", hasSize(2)) )
		;
	}
	*/

	@Test
	void testBuscarDuenios() throws Exception {
		mockMvc.perform( get("/duenios/buscar") )
		.andExpect( status().isOk() )
		.andExpect( view().name("duenios/buscar"))
		;
		
		verifyZeroInteractions(ds);
	}
	
	@Test
	void procesarBuscarFormularioRegresaMuchos() throws Exception{
		when(ds.buscarPorApellidoLike(anyString())).thenReturn(
			Arrays.asList(
				Duenio.builder().id(1L).build(),
				Duenio.builder().id(2L).build()
			)
		);
		
		mockMvc.perform(get("/duenios"))
		.andExpect(status().isOk())
		.andExpect(view().name("duenios/lista"))
		.andExpect(model().attribute("listaDuenios", hasSize(2)))
		;
	}
	
	@Test
	void procesarBuscarFormularioRegresaUno() throws Exception{
		when(ds.buscarPorApellidoLike(anyString())).thenReturn(
			Arrays.asList(
				Duenio.builder().id(1L).build()
			)
		);
		
		mockMvc.perform(get("/duenios"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/duenios/1"))
		;
	}
	
	@Test
	void procesarBusquedaFormEmptyRegresaMuchos() throws Exception {
		when(ds.buscarPorApellidoLike(anyString()))
		.thenReturn(
			Arrays.asList(
				Duenio.builder().id(1L).build(),
				Duenio.builder().id(2L).build()
			)
		)
		;
		
		mockMvc.perform(get("/duenios").param("apellido", ""))
		.andExpect(status().isOk())
		.andExpect(view().name("duenios/lista"))
		.andExpect(model().attribute("listaDuenios", hasSize(2)))
		;
	}
	
	@Test
	void testMostrarDuenio() throws Exception {
		when(ds.findById(anyLong())).thenReturn(Duenio.builder().id(1L).build());
		
		mockMvc.perform( get("/duenios/123") )
		.andExpect( status().isOk() )
		.andExpect( view().name("duenios/detalle") )
		.andExpect( model().attribute("duenio", hasProperty("id", is(1L) ) ) )
		;
	}
	
	@Test
	void iniciarCreacionFormulario() throws Exception {
		mockMvc.perform(get("/duenios/nuevo"))
		.andExpect(status().isOk())
		.andExpect(view().name("duenios/formularioCrearOActualizar"))
		.andExpect(model().attributeExists("duenio"))
		;
		
		verifyZeroInteractions(ds);
	}
	
	@Test
	void procesarCreacionFormulario() throws Exception{
		when(ds.save(ArgumentMatchers.any())).thenReturn(Duenio.builder().id(1L).build());
		mockMvc.perform(post("/duenios/nuevo"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/duenios/1"))
		.andExpect(model().attributeExists("duenio"))
		;
		
		verify(ds).save(ArgumentMatchers.any());
	}
	
	@Test
	void iniciarActualizacionDuenioFormulario() throws Exception {
		when(ds.findById(anyLong())).thenReturn(Duenio.builder().id(1L).build());
		mockMvc.perform(get("/duenios/1/editar"))
			.andExpect(status().isOk())
			.andExpect(view().name("duenios/formularioCrearOActualizar"))
			.andExpect(model().attributeExists("duenio"))
			;
		verifyZeroInteractions(ds);
	}
	
	@Test
	void procesarActualizarDuenioFormulario() throws Exception{
		when(ds.save(ArgumentMatchers.any())).thenReturn(Duenio.builder().id(1L).build());
		
		mockMvc.perform(post("/duenios/1/editar"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/duenios/1"))
		.andExpect(model().attributeExists("duenio"))
		;
		
		verify(ds).save(ArgumentMatchers.any());
	}
}
