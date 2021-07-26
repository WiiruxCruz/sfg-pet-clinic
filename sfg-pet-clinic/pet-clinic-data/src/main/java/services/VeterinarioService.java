package services;

import java.util.Set;

import model.Veterinario;

public interface VeterinarioService {
	Veterinario buscarPorId(Veterinario v);
	
	Veterinario guardar(Veterinario v);
	
	Set<Veterinario> buscarTodos();
}
