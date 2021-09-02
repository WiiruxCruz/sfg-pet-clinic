package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.Visita;
import mx.com.wiirux.sfgpetclinic.services.VisitaService;

@Service
public class VisitServiceMap extends AbstractMapService<Visita, Long> implements VisitaService{

	@Override
	public Set<Visita> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Visita findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Visita save(Visita visita) {
		// TODO Auto-generated method stub
		
		if(
			visita.getMascota() == null
			|| visita.getMascota().getDuenio() == null
			|| visita.getMascota().getId() == null
			|| visita.getMascota().getDuenio().getId() == null
		) {
			throw new RuntimeException("Visita invalida");
		}
		
		return super.save(visita);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Visita object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
}
