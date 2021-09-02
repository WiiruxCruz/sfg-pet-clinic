package mx.com.wiirux.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.TipoMascota;
import mx.com.wiirux.sfgpetclinic.repositories.TipoMascotaRepository;
import mx.com.wiirux.sfgpetclinic.services.TipoMascotaService;

@Service
@Profile("springdatajpa")
public class TipoMascotaSDJpaService implements TipoMascotaService{
	
	private final TipoMascotaRepository tmr;
	
	public TipoMascotaSDJpaService(TipoMascotaRepository tmr) {
		this.tmr = tmr;
	}

	@Override
	public Set<TipoMascota> findAll() {
		// TODO Auto-generated method stub
		Set<TipoMascota> tipoMascotas = new HashSet<>();
		
		tmr.findAll().forEach(tipoMascotas::add);
		
		return tipoMascotas;
	}

	@Override
	public TipoMascota findById(Long id) {
		// TODO Auto-generated method stub
		return tmr.findById(id).orElse(null);
	}

	@Override
	public TipoMascota save(TipoMascota object) {
		// TODO Auto-generated method stub
		return tmr.save(object);
	}

	@Override
	public void delete(TipoMascota object) {
		// TODO Auto-generated method stub
		tmr.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		tmr.deleteById(id);
	}

}
