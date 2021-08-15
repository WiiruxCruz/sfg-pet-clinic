package mx.com.wiirux.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Duenio extends Persona {
	
	private String direccion;
	private String ciudad;
	private String telefono;
	
	private Set<Mascota> mascotas = new HashSet<>();

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
	
}
