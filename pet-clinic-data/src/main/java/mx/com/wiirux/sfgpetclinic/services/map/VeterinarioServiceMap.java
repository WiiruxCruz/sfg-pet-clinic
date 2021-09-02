package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Especialidad;
import mx.com.wiirux.sfgpetclinic.model.Veterinario;
import mx.com.wiirux.sfgpetclinic.services.EspecialidadService;
import mx.com.wiirux.sfgpetclinic.services.VeterinarioService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class VeterinarioServiceMap extends AbstractMapService<Veterinario, Long> implements VeterinarioService{
	
	private final EspecialidadService es;
	
	public VeterinarioServiceMap(EspecialidadService es) {
		// TODO Auto-generated constructor stub
		this.es = es;
	}
	
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
		
		if(object.getEspecialidades().size() > 0) {
			object.getEspecialidades().forEach( especialidad -> {
				if(especialidad.getId() == null) {
					Especialidad savedEspecialidad = es.save(especialidad);
					especialidad.setId( savedEspecialidad.getId() );
				}
			});
		}
		
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
