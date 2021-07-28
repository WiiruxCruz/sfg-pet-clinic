package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Mascota;
import mx.com.wiirux.sfgpetclinic.services.CrudService;

public class MascotaSercviceMap extends AbstractMapService<Mascota, Long> implements CrudService<Mascota, Long>{
	
	@Override
	public Set<Mascota> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Mascota findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	
	@Override
	public Mascota save(Mascota object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Mascota object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
	
}
