package mx.com.wiirux.sfgpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.com.wiirux.sfgpetclinic.model.Duenio;

public interface DuenioRepository extends CrudRepository<Duenio, Long>{
	/*
	 * Para que puedas implementar este metodo, como usa JPA, debe llemarse igual que el atributo de la entidad
	Duenio buscarPorApellido(String apellido);
	*/
	Duenio findByApellido(String apellido);
	List<Duenio> findAllByApellidoLike(String apellido);
	
}
