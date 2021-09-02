package mx.com.wiirux.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.Especialidad;
import mx.com.wiirux.sfgpetclinic.repositories.EspecialidadRepository;
import mx.com.wiirux.sfgpetclinic.services.EspecialidadService;

@Service
@Profile("springdatajpa")
public class EspecialidadSDJpaService implements EspecialidadService{
	
	private final EspecialidadRepository er;
	
	public EspecialidadSDJpaService(EspecialidadRepository er) {
		// TODO Auto-generated constructor stub
		this.er = er;
	}

	@Override
	public Set<Especialidad> findAll() {
		// TODO Auto-generated method stub
		Set<Especialidad> especialidades = new HashSet<>();
		
		er.findAll().forEach(especialidades::add);
		
		return especialidades;
	}

	@Override
	public Especialidad findById(Long id) {
		// TODO Auto-generated method stub
		return er.findById(id).orElse(null);
	}

	@Override
	public Especialidad save(Especialidad object) {
		// TODO Auto-generated method stub
		return er.save(object);
	}

	@Override
	public void delete(Especialidad object) {
		// TODO Auto-generated method stub
		er.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
	}
}
