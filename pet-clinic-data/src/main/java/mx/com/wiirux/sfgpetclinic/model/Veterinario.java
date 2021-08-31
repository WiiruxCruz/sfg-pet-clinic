package mx.com.wiirux.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veterinario")
public class Veterinario extends Persona {
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "veterinario_especialidad",
		joinColumns = @JoinColumn(name = "veterinario_id"),
		inverseJoinColumns = @JoinColumn(name = "especialidad_id")
	)
	private Set<Especialidad> especialidades = new HashSet<>();

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
}
