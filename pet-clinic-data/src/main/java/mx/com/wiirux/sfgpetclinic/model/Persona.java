package mx.com.wiirux.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Persona extends BaseEntity{
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;

	public Persona(Long id, String nombre, String apellido) {
		super(id);
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	
}
