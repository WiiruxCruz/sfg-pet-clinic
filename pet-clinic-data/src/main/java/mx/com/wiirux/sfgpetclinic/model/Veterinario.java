package mx.com.wiirux.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Veterinario extends Persona {
	private Set<Especialidad> especialidades = new HashSet<>();

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
}
