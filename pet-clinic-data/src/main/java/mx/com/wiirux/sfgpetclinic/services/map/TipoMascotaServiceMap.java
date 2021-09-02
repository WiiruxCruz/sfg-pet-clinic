package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.TipoMascota;
import mx.com.wiirux.sfgpetclinic.services.TipoMascotaService;

@Service
@Profile({"default","map"})
public class TipoMascotaServiceMap extends AbstractMapService<TipoMascota, Long> implements TipoMascotaService{

	@Override
	public Set<TipoMascota> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public TipoMascota findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public TipoMascota save(TipoMascota object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(TipoMascota object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
	
}
