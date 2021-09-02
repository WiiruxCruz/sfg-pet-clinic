package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.Especialidad;
import mx.com.wiirux.sfgpetclinic.services.EspecialidadService;

@Service
@Profile({"default","map"})
public class EspecialidadServiceMap extends AbstractMapService<Especialidad, Long> implements EspecialidadService{

	@Override
	public Set<Especialidad> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Especialidad findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Especialidad save(Especialidad object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Especialidad object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
	
}
