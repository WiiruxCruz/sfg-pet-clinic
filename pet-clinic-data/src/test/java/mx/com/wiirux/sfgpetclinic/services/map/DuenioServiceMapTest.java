package mx.com.wiirux.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.com.wiirux.sfgpetclinic.model.Duenio;

class DuenioServiceMapTest {
	
	DuenioServiceMap dsm;
	
	final String duenioApellido = "Ramirez";
	final Long duenioId = 1L;

	@BeforeEach
	void setUp() throws Exception {
		dsm = new DuenioServiceMap(new TipoMascotaServiceMap(), new MascotaServiceMap());
		
		
		/*
		 * Creación normal
		Duenio duenioGuardar = new Duenio();
		duenioGuardar.setId(duenioId);
		duenioGuardar.setApellido(duenioApellido);
		*/
		/*
		 * Patron builder
		Duenio duenioGuardar = Duenio
				.builder()
				.id(1L)
				.apellido("Ramirez")
				.nombre("Hiram")
				.ciudad("Veracruz")
				.direccion("Casa")
				.telefono("1234567890")
				.build();
		
		dsm.save(duenioGuardar);
		*/
	
		dsm.save(
				Duenio
					.builder()
					.id(duenioId)
					.apellido(duenioApellido)
					.build()
		);
	}

	@Test
	void testFindAll() {
		Set<Duenio> duenioSet = dsm.findAll();
		
		assertEquals(1,  duenioSet.size());
	}

	@Test
	void testFindByIdLong() {
		Duenio duenio = dsm.findById(duenioId);
		
		assertEquals(duenioId, duenio.getId());
	}

	@Test
	void testSaveDuenio() {
		Long id = 2L;
		Duenio duenio2 = Duenio.builder().id(id).build();
		Duenio duenioSalvado = dsm.save(duenio2);
		assertEquals(id, duenioSalvado.getId());
	}
	
	@Test
	void testSaveDuenioNoId() {
		Duenio duenioSalvado = dsm.save( Duenio.builder().build() );
		assertNotNull(duenioSalvado);
		assertNotNull(duenioSalvado.getId());
	}
	
	@Test
	void testDeleteDuenio() {
		dsm.delete(dsm.findById(duenioId));
		assertEquals(0, dsm.findAll().size());
	}
	
	@Test
	void testDeleteByIdLong() {
		dsm.deleteById(duenioId);
		assertEquals(0, dsm.findAll().size());
	}
	
	@Test
	void testBuscarPorApellido() {
		Duenio ramirez = dsm.buscarPorApellido(duenioApellido);
		assertNotNull(ramirez);
		assertEquals(duenioId, ramirez.getId());
	}
	
	@Test
	void testBuscarPorApellidoNoEncontrado() {
		Duenio ramirez = dsm.buscarPorApellido("Otro apellido");
		
		assertNull(ramirez);
	}

}
