package services;

import java.util.Set;

import model.Duenio;

public interface DuenioService {
	Duenio buscarPorApellido(String apellido);
	
	Duenio buscarPorId(Long d);
	
	Duenio guardar(Duenio d);
	
	Set<Duenio> buscarTodos();
}
