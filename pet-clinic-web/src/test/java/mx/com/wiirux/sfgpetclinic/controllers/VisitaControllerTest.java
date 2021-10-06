package mx.com.wiirux.sfgpetclinic.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.model.Mascota;
import mx.com.wiirux.sfgpetclinic.model.TipoMascota;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;
import mx.com.wiirux.sfgpetclinic.services.MascotaService;
import mx.com.wiirux.sfgpetclinic.services.VisitaService;

@ExtendWith(MockitoExtension.class)
class VisitaControllerTest {
	
	private static final String MASCOTAS_CREAR_O_ACTUALIZAR_FORM = "mascotas/formularioCrearOActualizarVisita";
    private static final String REDIRIGIR_DUENIOS_1 = "redirect:/duenios/{duenioId}";
    private static final String OTRA_DESCRIPCION_VISITA = "yet another visit";
	
    @Mock
	DuenioService duenioService;
    
    @Mock
	MascotaService mascotaService;
	
	@Mock
	VisitaService visitaService;
	
	@InjectMocks
	VisitaController visitaController;
	
	private MockMvc mockMvc;
	
	private final UriTemplate visitaUriTemplate = new UriTemplate("/duenios/{duenioId}/mascotas/{mascotaId}/visitas/nuevo");
	
	private final Map<String, String> uriVariables = new HashMap<>();
	private URI visitasUri;
	
	Duenio duenio;
	Mascota mascota;

	@BeforeEach
	void setUp() throws Exception {
		
		Long mascotaId = 1L;
		Long duenioId = 1L;
		
		/*
		duenio = Duenio.builder().id(1L).build();
		
		mascota = Mascota.builder().id(1L).build();
		

		mockMvc = MockMvcBuilders
				.standaloneSetup(visitaController)
				.build();
		*/
		
		
		when(mascotaService.findById(anyLong())).thenReturn(
			Mascota.builder()
			.id(mascotaId)
			.fechaNacimiento(LocalDate.of(2018,11,13))
			.nombre("Gatito")
			.visitas(new HashSet<>())
			.duenio(
				Duenio.builder()
				.id(duenioId)
				.apellido("Ramirez")
				.nombre("Hiram")
				.build()
			)
			.tipoMascota(
				TipoMascota.builder()
				.tipo("Perro")
				.build()
			)
			.build()
		);
		
		uriVariables.clear();
		uriVariables.put("duenioId", duenioId.toString());
		uriVariables.put("mascotaId", mascotaId.toString());
		visitasUri = visitaUriTemplate.expand(uriVariables);
		
		mockMvc = MockMvcBuilders.standaloneSetup(visitaController).build();
		
	}

	@Test
	void testIniciarNuevaVisitaForm() throws Exception{
		
		mockMvc.perform(get(visitasUri))
		.andExpect(status().isOk())
		.andExpect(view().name(MASCOTAS_CREAR_O_ACTUALIZAR_FORM))
		;
		
	}

	@Test
	void testProcesarNuevaVisitaForm() throws Exception{
		
		//when(duenioService.findById(anyLong())).thenReturn(duenio);
		//when(mascotaService.findById(anyLong())).thenReturn(mascota);
		
		/*
		mockMvc.perform(post("/duenios/1/mascotas/1/visitas/nuevo"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name(REDIRIGIR_DUENIOS_1))
		;
		*/
		
		//verify(visitaService).save(any());
		
		
		mockMvc.perform(
			post(visitasUri)
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
			.param("date", "2018-11-11")
			.param("descripcion", OTRA_DESCRIPCION_VISITA)
		)
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name(REDIRIGIR_DUENIOS_1))
		.andExpect(model().attributeExists("visita"))
		;
		
	}

}
