package mx.com.wiirux.sfgpetclinic.services;

import mx.com.wiirux.sfgpetclinic.model.Duenio;

public interface DuenioService extends CrudService<Duenio, Long> {
	Duenio buscarPorApellido(String apellido);
	
}
