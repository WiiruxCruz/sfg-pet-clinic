package mx.com.wiirux.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.model.Mascota;
import mx.com.wiirux.sfgpetclinic.model.TipoMascota;
import mx.com.wiirux.sfgpetclinic.model.Veterinario;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;
import mx.com.wiirux.sfgpetclinic.services.TipoMascotaService;
import mx.com.wiirux.sfgpetclinic.services.VeterinarioService;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final DuenioService ds;
	private final VeterinarioService vs;
	private final TipoMascotaService tms;
	
	
	@Autowired
	public DataLoader(DuenioService ds, VeterinarioService vs, TipoMascotaService tms) {
		this.ds = ds;
		this.vs = vs;
		this.tms = tms;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		TipoMascota perro = new TipoMascota();
		perro.setTipo("perro");
		TipoMascota savedDogPetTipoMascota = tms.save(perro);
		
		TipoMascota gato = new TipoMascota();
		perro.setTipo("gato");
		TipoMascota savedCatPetTipoMascota = tms.save(gato);
		System.out.println("Mascotas cargadas...");
		
		Duenio d1 = new Duenio();
		d1.setId(1L);
		d1.setNombre("Michael");
		d1.setApellido("Weston");
		d1.setDireccion("Laguna la miel 96");
		d1.setCiudad("Veracruz");
		d1.setTelefono("2291036258");
		
		Mascota m1 = new Mascota();
		m1.setTipoMascota(savedDogPetTipoMascota);
		m1.setDuenio(d1);
		m1.setFechaNacimiento(LocalDate.now());
		m1.setNombre("Bingo");
		d1.getMascotas().add(m1);
		
		ds.save(d1);
		
		Duenio d2 = new Duenio();
		d2.setId(2L);
		d2.setNombre("Fiona");
		d2.setApellido("Glenanne");
		d2.setDireccion("Bougambilias 490");
		d2.setDireccion("Veracruz");
		d2.setTelefono("2295508085");
		
		Mascota m2 = new Mascota();
		m2.setNombre("Gatito");
		m2.setDuenio(d2);
		m2.setFechaNacimiento(LocalDate.now());
		m2.setTipoMascota(savedCatPetTipoMascota);
		d2.getMascotas().add(m2);
		
		ds.save(d2);
		
		System.out.println("Duenios cargados...");
		
		Veterinario v1 = new Veterinario();
		v1.setId(1L);
		v1.setNombre("Sam");
		v1.setApellido("Axe");
		
		vs.save(v1);
		
		Veterinario v2 = new Veterinario();
		v2.setId(2L);
		v2.setNombre("Jessie");
		v2.setApellido("Porter");
		
		vs.save(v2);
		
		System.out.println("Veterinarios cargados...");
		
	}

}
