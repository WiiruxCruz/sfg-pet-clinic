package mx.com.wiirux.sfgpetclinic.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.model.TipoMascota;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;
import mx.com.wiirux.sfgpetclinic.services.MascotaService;
import mx.com.wiirux.sfgpetclinic.services.TipoMascotaService;

@Controller
@RequestMapping("/duenios/{duenioId}")
public class MascotaController {
	
	private static final String VISTA_MASCOTA_CREAR_O_ACTUALIZAR_FORM = "mascotas/formularioCrearOActualizar";
	private final MascotaService mascotaService;
	private final DuenioService duenioService;
	private final TipoMascotaService tipoMascotaService;
	
	public MascotaController(
		MascotaService mascotaService,
		DuenioService duenioService,
		TipoMascotaService tipoMascotaService
	) {
		this.mascotaService = mascotaService;
		this.duenioService = duenioService;
		this.tipoMascotaService = tipoMascotaService;
	}
	
	/*
	@RequestMapping({"/mascotas", "/mascotas/index", "/mascotas/index.html"})
	public String listaMascotas() {
		return "mascotas/index";
	}
	*/
	
	@ModelAttribute("tiposMascota")
	public Collection<TipoMascota> poblarTipoMascota(){
		return this.tipoMascotaService.findAll();
	}
	
	@ModelAttribute("duenios")
	public Duenio buscarDuenio(@PathVariable("duenioId") Long duenioId) {
		return this.duenioService.findById(duenioId);
	}
	
	@InitBinder("duenio")
	public void initduenioBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
}
