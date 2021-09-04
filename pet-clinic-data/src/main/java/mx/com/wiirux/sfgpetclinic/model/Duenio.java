package mx.com.wiirux.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

	@Builder
	public Duenio(Long id, String nombre, String apellido, String direccion, String ciudad, String telefono,
			Set<Mascota> mascotas) {
		super(id, nombre, apellido);
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.mascotas = mascotas;
	}
}
