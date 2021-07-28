package mx.com.wiirux.sfgpetclinic.services;

import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Veterinario;

public interface VeterinarioService {
	Veterinario buscarPorId(Veterinario v);
	
	Veterinario guardar(Veterinario v);
	
	Set<Veterinario> buscarTodos();
}
