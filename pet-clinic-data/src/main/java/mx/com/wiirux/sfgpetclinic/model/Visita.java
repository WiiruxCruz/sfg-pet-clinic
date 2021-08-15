package mx.com.wiirux.sfgpetclinic.model;

import java.time.LocalDate;

public class Visita extends BaseEntity{
	private LocalDate date;
	private String descripcion;
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
	public void setM(Mascota mascota) {
		this.mascota = mascota;
	}
	
	 
}
