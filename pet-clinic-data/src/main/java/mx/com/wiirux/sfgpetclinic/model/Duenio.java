package mx.com.wiirux.sfgpetclinic.model;

import java.util.Set;

public class Duenio extends Persona {
	private Set<Mascota> mascotas;

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
}
