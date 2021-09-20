package mx.com.wiirux.sfgpetclinic.services;

import java.util.List;

import mx.com.wiirux.sfgpetclinic.model.Duenio;

public interface DuenioService extends CrudService<Duenio, Long> {
	Duenio buscarPorApellido(String apellido);
	List<Duenio> buscarPorApellidoLike(String apellido);
}
