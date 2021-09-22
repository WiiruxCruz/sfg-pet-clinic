package mx.com.wiirux.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.model.Mascota;
import mx.com.wiirux.sfgpetclinic.model.TipoMascota;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;
import mx.com.wiirux.sfgpetclinic.services.MascotaService;
import mx.com.wiirux.sfgpetclinic.services.TipoMascotaService;

@ExtendWith(MockitoExtension.class)
class MascotaControllerTest {
	
	@Mock
	MascotaService mascotaService;
	
	@Mock
	DuenioService duenioService;
	
	@Mock
	TipoMascotaService tipoMascotaService;
	
	@InjectMocks
	MascotaController mascotaController;
	
	MockMvc mockMvc;
	
	Duenio duenio;
	Set<TipoMascota> tipoMascotas;

	@BeforeEach
	void setUp() throws Exception {
		duenio = Duenio.builder().id(1L).build();
		
		tipoMascotas = new HashSet<>();
		tipoMascotas.add(TipoMascota.builder().id(1L).tipo("Dog").build());
		tipoMascotas.add(TipoMascota.builder().id(2L).tipo("Cat").build());
		
		mockMvc = MockMvcBuilders
				.standaloneSetup(mascotaController)
				.build();
	}

	@Test
	void testPoblarTipoMascota() throws Exception{
		//pending
	}

	@Test
	void testBuscarDuenio() {
		//pending
	}

	@Test
	void testInitduenioBinder() {
		//pending
	}

	@Test
	void testIniciarCreacionFormulario() throws Exception{
		when(duenioService.findById(anyLong())).thenReturn(duenio);
		when(tipoMascotaService.findAll()).thenReturn(tipoMascotas);
		
		mockMvc.perform(get("/duenios/1/mascotas/nuevo"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("duenio"))
		.andExpect(model().attributeExists("mascota"))
		.andExpect(view().name("mascotas/formularioCrearOActualizar"))
		;
	}

	@Test
	void testProcesarCreacionFormulario() throws Exception{
		when(duenioService.findById(anyLong())).thenReturn(duenio);
		when(tipoMascotaService.findAll()).thenReturn(tipoMascotas);
		
		mockMvc.perform(post("/duenios/1/mascotas/nuevo"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/duenios/1"))
		;
		
		verify(mascotaService).save(any());
	}

	@Test
	void testIniciarActualizacionFormulario() throws Exception{
		when(duenioService.findById(anyLong())).thenReturn(duenio);
		when(tipoMascotaService.findAll()).thenReturn(tipoMascotas);
		when(mascotaService.findById(anyLong())).thenReturn(Mascota.builder().id(2L).build());
		
		mockMvc.perform(get("/duenios/1/mascotas/2/editar"))
		.andExpect(status().isOk())
		//.andExpect(model().attributeExists("duenio"))
		.andExpect(model().attributeExists("mascota"))
		.andExpect(view().name("mascotas/formularioCrearOActualizar"))
		;
	}

	@Test
	void testProcesarActualizaciónFormulario() throws Exception{
		when(duenioService.findById(anyLong())).thenReturn(duenio);
		when(tipoMascotaService.findAll()).thenReturn(tipoMascotas);
		
		mockMvc.perform(post("/duenios/1/mascotas/2/editar"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/duenios/1"))
		;
		
		verify(mascotaService).save(any());
	}

}
