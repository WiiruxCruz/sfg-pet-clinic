package mx.com.wiirux.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.Mascota;
import mx.com.wiirux.sfgpetclinic.repositories.MascotaRepository;
import mx.com.wiirux.sfgpetclinic.services.MascotaService;

@Service
@Profile("springdatajpa")
public class MascotaSDJpaService implements MascotaService{
	private final MascotaRepository mr;
	
	public MascotaSDJpaService(MascotaRepository mr) {
		this.mr = mr;
	}

	@Override
	public Set<Mascota> findAll() {
		// TODO Auto-generated method stub
		Set<Mascota> mascotas = new HashSet<>();
		
		mr.findAll().forEach(mascotas::add);
		
		return mascotas;
	}

	@Override
	public Mascota findById(Long id) {
		// TODO Auto-generated method stub
		return mr.findById(id).orElse(null);
	}

	@Override
	public Mascota save(Mascota object) {
		// TODO Auto-generated method stub
		return mr.save(object);
	}

	@Override
	public void delete(Mascota object) {
		// TODO Auto-generated method stub
		mr.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		mr.deleteById(id);
	}
}
