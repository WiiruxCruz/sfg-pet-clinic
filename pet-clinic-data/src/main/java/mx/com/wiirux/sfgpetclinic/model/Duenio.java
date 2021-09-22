package mx.com.wiirux.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "duenios")
public class Duenio extends Persona {
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "telefono")
	private String telefono;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "duenio")
	private Set<Mascota> mascotas = new HashSet<>();

	@Builder
	public Duenio(Long id, String nombre, String apellido, String direccion, String ciudad,
			String telefono, Set<Mascota> mascotas) {
		super(id, nombre, apellido);
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		if(mascotas != null) {
			this.mascotas = mascotas;
		}
	}
	
	/*
	 * Regresa la mascota con el nombre indicado o nulo si no se encuentra para este duenio
	*/
	public Mascota getMascota(String nombre) {
		return getMascota(nombre, false);
	}
	
	/*
	 * Regresa la mascota con el nombre indicado o nulo si no se encuentra para este duenio
	*/
	public Mascota getMascota(String nombre, boolean ignorarNuevo) {
		nombre = nombre.toLowerCase();
		for(Mascota mascota : this.mascotas) {
			if(!ignorarNuevo || !mascota.isNew()) {
				String compararNombre = mascota.getNombre();
				compararNombre = compararNombre.toLowerCase();
				if(compararNombre.equals(nombre)) {
					return mascota;
				}
			}
		}
		return null;
	}
}
