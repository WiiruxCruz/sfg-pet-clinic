package mx.com.wiirux.sfgpetclinic.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;

@RequestMapping("/duenios")
@Controller
public class DuenioController {
	
	private final DuenioService ds;
	
	public DuenioController(DuenioService ds) {
		// TODO Auto-generated constructor stub
		this.ds = ds;
	}
	
	@InitBinder
	public void establecerCamposPermitidos(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	/*
	@RequestMapping({"","/","/index","/index.html"})
	public String listaDuenios(Model m) {
		m.addAttribute("duenios", ds.findAll());
		
		return "duenios/index";
	}
	*/
	
	@RequestMapping("/buscar")
	public String buscarDuenios(Model model) {
		model.addAttribute("duenio", Duenio.builder().build());
		return "duenios/buscar";
	}
	
	@GetMapping({"","/","/index","/index.html"})
	public String procesarBusquedaFormulario(Duenio duenio, BindingResult resultado, Model model) {
		//permitir parameterless GET solicitudes para /duenios al regresar todos los resultados
		if(duenio.getApellido() == null) {
			duenio.setApellido("");
		}
		
		//buscar duenio por apellido
		List<Duenio> resultados = ds.buscarPorApellidoLike( "%" + duenio.getApellido() + "%");
		
		if(resultados.isEmpty()) {
			//no found
			resultado.rejectValue("apellido", "no encontrado", "no encontrado");
			return "duenios/buscar";
		} else if(resultados.size() == 1) {
			duenio = resultados.get(0);
			return "redirect:/duenios/" + duenio.getId();
		} else {
			model.addAttribute("listaDuenios", resultados);
			return "duenios/lista";
		}
		
	}
	
	@GetMapping("/{duenioId}")
	public ModelAndView mostrarDuenio(@PathVariable("duenioId") Long duenioId) {
		System.out.println("Estoy aqui con:" + duenioId);
		ModelAndView mav = new ModelAndView("duenios/detalle");
		
		mav.addObject(this.ds.findById(duenioId));
		
		return mav;
	}
}
