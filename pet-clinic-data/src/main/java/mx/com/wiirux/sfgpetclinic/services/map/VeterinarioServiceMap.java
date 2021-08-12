package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Veterinario;
import mx.com.wiirux.sfgpetclinic.services.VeterinarioService;

import org.springframework.stereotype.Service;

@Service
public class VeterinarioServiceMap extends AbstractMapService<Veterinario, Long> implements VeterinarioService{
	
	@Override
	public Set<Veterinario> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Veterinario findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	
	@Override
	public Veterinario save(Veterinario object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Veterinario object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
	
}
