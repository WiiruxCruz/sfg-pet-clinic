package mx.com.wiirux.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "duenio")
public class Duenio extends Persona {
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "telefono")
	private String telefono;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "duenio")
	private Set<Mascota> mascotas = new HashSet<>();
	
	//private String buscarPorApellido;

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
	
	/*
	 * Metodo de prueba para ver que funciona con JPA, descomentar en DuenioRepository
	public String getBuscarPorApellido() {
		return buscarPorApellido;
	}

	public void setBuscarPorApellido(String buscarPorApellido) {
		this.buscarPorApellido = buscarPorApellido;
	}
	*/
	
	
}
