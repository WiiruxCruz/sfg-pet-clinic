package mx.com.wiirux.sfgpetclinic.services.springdatajpa;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.repositories.DuenioRepository;
import mx.com.wiirux.sfgpetclinic.repositories.MascotaRepository;
import mx.com.wiirux.sfgpetclinic.repositories.TipoMascotaRepository;

@ExtendWith(MockitoExtension.class)
class DuenioSDJpaServiceTest {
	
	private static final String APELLIDO_RAMIREZ = "Ramirez";
	private static final Long ID_DUENIO = 1L;
	@Mock
	DuenioRepository dr;
	@Mock
	MascotaRepository mr;
	@Mock
	TipoMascotaRepository tmr;
	@InjectMocks
	DuenioSDJpaService service;
	
	Duenio returnDuenio;

	@BeforeEach
	void setUp() {
		returnDuenio = Duenio.builder().id(ID_DUENIO).apellido(APELLIDO_RAMIREZ).build();
	}
	
	@Test
	void testBuscarPorApellido() {
		
		when(service.buscarPorApellido(any())).thenReturn(returnDuenio);
		
		Duenio duenioRamirez = service.buscarPorApellido(APELLIDO_RAMIREZ);
		
		assertEquals(APELLIDO_RAMIREZ, duenioRamirez.getApellido());
		
		verify(dr).findByApellido(any());
	}

	@Test
	void testFindAll() {
		Set<Duenio> returnDuenioSet = new HashSet<>();
		returnDuenioSet.add(Duenio.builder().id(1L).build());
		returnDuenioSet.add(Duenio.builder().id(2L).build());
		
		when(dr.findAll()).thenReturn(returnDuenioSet);
		Set<Duenio> duenios = service.findAll();
		
		assertNotNull(duenios);
		assertEquals(2, duenios.size());
		
	}

	@Test
	void testFindById() {
		when(dr.findById(anyLong())).thenReturn(Optional.of(returnDuenio));
		
		Duenio duenio = service.findById(1L);
		
		assertNotNull(duenio);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(dr.findById(anyLong())).thenReturn(Optional.empty());
		
		Duenio duenio = service.findById(1L);
		
		assertNull(duenio);
	}

	@Test
	void testSave() {
		Duenio salvarDuenio = Duenio.builder().id(1L).build();
		when(dr.save(any())).thenReturn(returnDuenio);
		Duenio duenioSalvado = service.save(salvarDuenio);
		assertNotNull(duenioSalvado);
	}

	@Test
	void testDelete() {
		service.delete(returnDuenio);
		
		//default is 1 times
		verify(dr, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		verify(dr).deleteById(anyLong());
	}
}
