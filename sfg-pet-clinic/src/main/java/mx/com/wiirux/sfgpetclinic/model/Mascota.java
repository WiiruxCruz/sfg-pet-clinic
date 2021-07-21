package mx.com.wiirux.sfgpetclinic.model;

import java.time.LocalDate;

public class Mascota {
	private TipoMascota tm;
	private Duenio d;
	private LocalDate fechaNacimiento;
	
	public TipoMascota getTm() {
		return tm;
	}
	public void setTm(TipoMascota tm) {
		this.tm = tm;
	}
	public Duenio getD() {
		return d;
	}
	public void setD(Duenio d) {
		this.d = d;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//comentario prueba
}
