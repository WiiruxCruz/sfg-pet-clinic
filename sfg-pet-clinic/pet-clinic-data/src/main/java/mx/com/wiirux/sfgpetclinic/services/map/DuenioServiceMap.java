package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;
import org.springframework.stereotype.Service;

@Service
public class DuenioServiceMap extends AbstractMapService<Duenio, Long> implements DuenioService{

	@Override
	public Set<Duenio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Duenio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	
	@Override
	public Duenio save(Duenio object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}
	

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Duenio object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public Duenio buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
