package mx.com.wiirux.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tipoMascota")
public class TipoMascota extends BaseEntity{
	
	@Builder
	public TipoMascota(Long id, String tipo) {
		super(id);
		this.tipo = tipo;
	}
	
	@Column(name = "tipo")
	private String tipo;

	@Override
	public String toString() {
		return tipo;
	}
	
	
}
