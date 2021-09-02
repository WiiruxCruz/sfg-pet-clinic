package mx.com.wiirux.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.Visita;
import mx.com.wiirux.sfgpetclinic.repositories.VisitaRepository;
import mx.com.wiirux.sfgpetclinic.services.VisitaService;

@Service
@Profile("springdatajpa")
public class VisitaSDJpaService implements VisitaService{
	
	private final VisitaRepository vr;

	public VisitaSDJpaService(VisitaRepository vr) {
		this.vr = vr;
	}

	@Override
	public Set<Visita> findAll() {
		// TODO Auto-generated method stub
		Set<Visita> visitas = new HashSet<>();
		
		vr.findAll().forEach(visitas::add);
		
		return visitas;
	}

	@Override
	public Visita findById(Long id) {
		// TODO Auto-generated method stub
		return vr.findById(id).orElse(null);
	}

	@Override
	public Visita save(Visita object) {
		// TODO Auto-generated method stub
		return vr.save(object);
	}

	@Override
	public void delete(Visita object) {
		// TODO Auto-generated method stub
		vr.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		vr.deleteById(id);
	}
	
}
