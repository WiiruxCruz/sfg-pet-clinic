package mx.com.wiirux.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.wiirux.sfgpetclinic.services.VeterinarioService;

@Controller
public class VeterinarioController {
	private final VeterinarioService vs;
	
	public VeterinarioController(VeterinarioService vs) {
		this.vs = vs;
	}
	
	@RequestMapping({"/veterinarios","/veterinarios/index","/veterinarios/index.html", "/veterinarios.html"})
	public String listaVeterinarios(Model m) {
		
		m.addAttribute("veterinarios", vs.findAll());
		
		return "veterinarios/index";
	}
}
