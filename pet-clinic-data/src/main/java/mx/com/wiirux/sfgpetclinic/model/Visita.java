package mx.com.wiirux.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "visita")
public class Visita extends BaseEntity{
	
	@Column(name = "fecha")
	private LocalDate date;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "mascota_id")
	private Mascota mascota;
	
}
