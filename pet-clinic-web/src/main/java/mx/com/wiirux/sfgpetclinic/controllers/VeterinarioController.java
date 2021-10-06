package mx.com.wiirux.sfgpetclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.wiirux.sfgpetclinic.model.Veterinario;
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
	
	@GetMapping("/api/veterinarios")
	@ResponseBody
	public Set<Veterinario> obtenerVeterinariosJson() {
		return vs.findAll();
	}
}
