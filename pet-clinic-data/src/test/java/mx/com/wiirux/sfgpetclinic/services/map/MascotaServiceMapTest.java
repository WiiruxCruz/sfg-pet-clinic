package mx.com.wiirux.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.com.wiirux.sfgpetclinic.model.Mascota;

class MascotaServiceMapTest {
	
	private MascotaServiceMap mascotaServiceMap;
	
	private final Long mascotaId = 1L;

	@BeforeEach
	void setUp() throws Exception {
		mascotaServiceMap = new MascotaServiceMap();
		
		mascotaServiceMap.save(Mascota.builder().id(mascotaId).build());
	}

	@Test
	void testFindAll() {
		Set<Mascota> mascotaSet = mascotaServiceMap.findAll();
		assertEquals(1,  mascotaSet.size());
	}

	@Test
	void testFindByExistingId() {
		Mascota mascota = mascotaServiceMap.findById(mascotaId);
		assertEquals(mascotaId, mascota.getId());
	}
	
	@Test
	void testFindByNotExistingId() {
		Mascota mascota = mascotaServiceMap.findById(10L);
		assertNull(mascota);
	}
	
	@Test
	void testFindByIdNull() {
		Mascota mascota = mascotaServiceMap.findById(null);
		assertNull(mascota);
	}

	@Test
	void testSaveMascota() {
		Long id = 2L;
		Mascota mascota2 = Mascota.builder().id(id).build();
		
		Mascota mascotaGuardada = mascotaServiceMap.save(mascota2);
		
		assertEquals(id, mascotaGuardada.getId());
	}
	
	@Test
	void saveDuplicateId() {
		Long id = 1L;
		Mascota mascota2 = Mascota.builder().id(id).build();
		
		Mascota mascotaGuardada = mascotaServiceMap.save(mascota2);
		
		assertEquals(id, mascotaGuardada.getId());
		assertEquals(1,  mascotaServiceMap.findAll().size());
	}
	
	@Test
	void saveNoId(){
		Mascota mascotaGuardada = mascotaServiceMap.save(Mascota.builder().build());
		assertNotNull(mascotaGuardada);
		assertNotNull(mascotaGuardada.getId());
		assertEquals(2, mascotaServiceMap.findAll().size());
	}

	@Test
	void testDeleteMascota() {
		mascotaServiceMap.delete(mascotaServiceMap.findById(mascotaId));
		assertEquals(0, mascotaServiceMap.findAll().size());
	}

	@Test
	void testDeleteMascotaIdEquivocado() {
		Mascota mascota = Mascota.builder().id(5L).build();
		mascotaServiceMap.delete(mascota);
		assertEquals(1, mascotaServiceMap.findAll().size());
	}
	
	@Test
	void testDeleteConIdNull() {
		Mascota mascota = Mascota.builder().build();
		mascotaServiceMap.delete(mascota);
		assertEquals(1,  mascotaServiceMap.findAll().size());
	}
	
	@Test
	void testDeleteConIdCorrecto() {
		mascotaServiceMap.deleteById(mascotaId);
		assertEquals(0,  mascotaServiceMap.findAll().size());
	}
	
	@Test
	void testDeleteConIdIncorrecto() {
		mascotaServiceMap.deleteById(5L);
		assertEquals(1,  mascotaServiceMap.findAll().size());
	}
	
	@Test
	void testDeleteConIdNullId() {
		mascotaServiceMap.deleteById(null);
		assertEquals(1,  mascotaServiceMap.findAll().size());
	}

}
