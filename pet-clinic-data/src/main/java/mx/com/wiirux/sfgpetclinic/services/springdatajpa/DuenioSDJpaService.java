package mx.com.wiirux.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.repositories.DuenioRepository;
import mx.com.wiirux.sfgpetclinic.repositories.MascotaRepository;
import mx.com.wiirux.sfgpetclinic.repositories.TipoMascotaRepository;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;

@Service
@Profile("springdatajpa")
public class DuenioSDJpaService implements DuenioService{
	
	private final DuenioRepository dr;
	private final MascotaRepository mr;
	private final TipoMascotaRepository tmr;
	
	public DuenioSDJpaService(DuenioRepository dr, MascotaRepository mr, TipoMascotaRepository tmr) {
		// TODO Auto-generated constructor stub
		this.dr = dr;
		this.mr = mr;
		this.tmr = tmr;
	}

	@Override
	public Set<Duenio> findAll() {
		// TODO Auto-generated method stub
		Set<Duenio> duenios = new HashSet<>();
		
		dr.findAll().forEach(duenios::add);;
		
		return duenios;
	}

	@Override
	public Duenio findById(Long id) {
		// TODO Auto-generated method stub
		/*
		Optional<Duenio> duenio = dr.findById(id).get();
		
		
		if( duenio.isPresent() ) {
			return duenio.get();
		} else {
			return null;
		}
		*/
		
		return dr.findById(id).orElse(null);
	}

	@Override
	public Duenio save(Duenio object) {
		// TODO Auto-generated method stub
		return dr.save(object);
	}

	@Override
	public void delete(Duenio object) {
		// TODO Auto-generated method stub
		dr.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
		
	}

	/*
	 * Aqui tuve que cambiar el nombre del metodo en la interfaz duenioRepository porque daba un error de JPA
	 * Could not create query metamodel for method public abstract
	 * lo tuve que cambiar a ingles
	 * EDIT:
	 * Para que funcione, debe existir ese atributo tal cual, la razón parece ser que esta relacionado con JPA
	 * */
	@Override
	public Duenio buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		
		//metodo que demuestra que funciona con JPA, descomentar en 
		//return dr.buscarPorApellido(apellido);
		
		return dr.findByApellido(apellido);
	}
	
	
	@Override
	public List<Duenio> buscarPorApellidoLike(String apellido) {
		// TODO Auto-generated method stub
		//NOTA: Aqui me paso lo mismo que el metodo de buscarPorApellido
		return dr.findAllByApellidoLike(apellido);
	}
}
