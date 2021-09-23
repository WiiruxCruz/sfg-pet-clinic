package mx.com.wiirux.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.com.wiirux.sfgpetclinic.model.Mascota;
import mx.com.wiirux.sfgpetclinic.model.Visita;
import mx.com.wiirux.sfgpetclinic.repositories.MascotaRepository;
import mx.com.wiirux.sfgpetclinic.repositories.VisitaRepository;
import mx.com.wiirux.sfgpetclinic.services.MascotaService;
import mx.com.wiirux.sfgpetclinic.services.VisitaService;

@Controller
public class VisitaController {
	
	private final VisitaService visitaService;
	private final MascotaService mascotaService;
	
	public VisitaController(
		VisitaService visitaService,
		MascotaService mascotaService
	) {
		this.visitaService = visitaService;
		this.mascotaService = mascotaService;
	}
	
	@InitBinder
	public void establecerCamposPermitidos(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	/**
	 * Called before each and every @RequestMapping annotated method. 
	 * 2 goals:
	 * - Make sure we always have fresh data
	 * - Since we do not use the session scope, make sure that Mascota object always has an id
	 * (Even though id is not part o f the form fields)
	*/
	@ModelAttribute("visita")
	public Visita cargarMascotaConVisita(
		@PathVariable("mascotaId") Long mascotaId,
		Model model
	) {
		Mascota mascota = mascotaService.findById(mascotaId);
		model.addAttribute("mascota", mascota);
		Visita visita = new Visita();
		mascota.getVisitas().add(visita);
		visita.setMascota(mascota);
		return visita;
	}
	
	//Spring MVC invoca al metodo cargarMascotaConVisita antes de iniciarNuevaVisitaForm
	@GetMapping("/duenios/{duenioId}/mascotas/{mascotaId}/visitas/nuevo")
	public String iniciarNuevaVisitaForm(
		@PathVariable("duenioId") Long duenioId,
		@PathVariable("mascotaId") Long mascotaId,
		Model model
	) {
		return "mascotas/formularioCrearOActualizarVisita";
	}
	
	@PostMapping("/duenios/{duenioId}/mascotas/{mascotaId}/visitas/nuevo")
	public String procesarNuevaVisitaForm(
		@Validated Visita visita,
		BindingResult resultado
	) {
		if(resultado.hasErrors()) {
			return "mascotas/formularioCrearOActualizar";
		} else {
			visitaService.save(visita);
			
			return "redirect:/duenios/{duenioId}";
		}
	}

}
