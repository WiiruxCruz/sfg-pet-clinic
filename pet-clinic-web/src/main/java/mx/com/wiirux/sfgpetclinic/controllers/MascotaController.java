package mx.com.wiirux.sfgpetclinic.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.model.Mascota;
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
	
	//Este es el que usa para poblar el listado de opciones de tipo Mascota
	@ModelAttribute("tiposMascotas")
	public Collection<TipoMascota> poblarTipoMascota(){
		return this.tipoMascotaService.findAll();
	}
	
	//este esta relacionado con el initBinder?
	//antes tenia duenios con s al final y no lo detectaba al hacer las pruebas
	//de MascotaController
	@ModelAttribute("duenio")
	public Duenio buscarDuenio(@PathVariable("duenioId") Long duenioId) {
		return this.duenioService.findById(duenioId);
	}
	
	@InitBinder("duenio")
	public void initduenioBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping("/mascotas/nuevo")
	public String iniciarCreacionFormulario(Duenio duenio, Model model) {
		Mascota mascota = new Mascota();
		duenio.getMascotas().add(mascota);
		mascota.setDuenio(duenio);
		model.addAttribute("mascota", mascota);
		return VISTA_MASCOTA_CREAR_O_ACTUALIZAR_FORM;
	}
	
	@PostMapping("/mascotas/nuevo")
	public String procesarCreacionFormulario(
		Duenio duenio,
		@Validated Mascota mascota,
		BindingResult resultado,
		ModelMap model
	) {
		if(
			StringUtils.hasLength(mascota.getNombre())
			&& mascota.isNew()
			&& duenio.getMascota(mascota.getNombre(), true) != null
		) {
			resultado.rejectValue("nombre", "duplicado", "ya existe uno anterior");
			
		}
		//duenio.getMascotas().add(mascota);
		mascota.setDuenio(duenio);
		if(resultado.hasErrors()) {
			model.put("mascota", mascota);
			return VISTA_MASCOTA_CREAR_O_ACTUALIZAR_FORM;
		} else {
			mascotaService.save(mascota);
			return "redirect:/duenios/" + duenio.getId();
		}
	}
	
	@GetMapping("/mascotas/{mascotaId}/editar")
	public String iniciarActualizacionFormulario(
		@PathVariable Long mascotaId,
		Model model
	) {
		model.addAttribute("mascota", mascotaService.findById(mascotaId));
		return VISTA_MASCOTA_CREAR_O_ACTUALIZAR_FORM;
	}
	
	@PostMapping("/mascotas/{mascotaId}/editar")
	public String procesarActualizaciónFormulario(
		@Validated Mascota mascota,
		BindingResult resultado,
		Duenio duenio,
		Model model
	) {
		if(resultado.hasErrors()) {
			mascota.setDuenio(duenio);
			model.addAttribute("mascota", mascota);
			return VISTA_MASCOTA_CREAR_O_ACTUALIZAR_FORM;
		} else {
			duenio.getMascotas().add(mascota);
			mascotaService.save(mascota);
			return "redirect:/duenios/" + duenio.getId();
		}
	}
	
}
