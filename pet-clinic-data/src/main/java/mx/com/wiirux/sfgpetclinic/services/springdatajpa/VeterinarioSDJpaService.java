package mx.com.wiirux.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.Veterinario;
import mx.com.wiirux.sfgpetclinic.repositories.VeterinarioRepository;
import mx.com.wiirux.sfgpetclinic.services.VeterinarioService;

@Service
@Profile("springdatajpa")
public class VeterinarioSDJpaService implements VeterinarioService{
	
	private final VeterinarioRepository vr;
	
	public VeterinarioSDJpaService(VeterinarioRepository vr) {
		// TODO Auto-generated constructor stub
		this.vr = vr;
	}

	@Override
	public Set<Veterinario> findAll() {
		// TODO Auto-generated method stub
		Set<Veterinario> veterinarios = new HashSet<>();
		
		vr.findAll().forEach(veterinarios::add);
		
		return veterinarios;
	}

	@Override
	public Veterinario findById(Long id) {
		// TODO Auto-generated method stub
		return vr.findById(id).orElse(null);
	}

	@Override
	public Veterinario save(Veterinario object) {
		// TODO Auto-generated method stub
		return vr.save(object);
	}

	@Override
	public void delete(Veterinario object) {
		// TODO Auto-generated method stub
		vr.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		vr.deleteById(id);
	}

}
