package mx.com.wiirux.sfgpetclinic.services;

import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Mascota;

public interface MascotaService {
	Mascota buscarPorId(Long id);
	
	Mascota guardar(Mascota m);
	
	Set<Mascota> buscarTodos();
}
