package services;

import java.util.Set;

import model.Mascota;

public interface MascotaService {
	Mascota buscarPorId(Long id);
	
	Mascota guardar(Mascota m);
	
	Set<Mascota> buscarTodos();
}
