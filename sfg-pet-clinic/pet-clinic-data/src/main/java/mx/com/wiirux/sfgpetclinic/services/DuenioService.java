package mx.com.wiirux.sfgpetclinic.services;

import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Duenio;

public interface DuenioService {
	Duenio buscarPorApellido(String apellido);
	
	Duenio buscarPorId(Long d);
	
	Duenio guardar(Duenio d);
	
	Set<Duenio> buscarTodos();
}
