package mx.com.wiirux.sfgpetclinic.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
	 
}
