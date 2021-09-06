package mx.com.wiirux.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

	@Test
	void testBuscarDuenios() throws Exception {
		mockMvc.perform( get("/duenios/buscar") )
		.andExpect( status().isOk() )
		.andExpect( view().name("noImplementado"))
		;
		
		verifyZeroInteractions(ds);
	}

}
