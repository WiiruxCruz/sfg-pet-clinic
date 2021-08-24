package mx.com.wiirux.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.wiirux.sfgpetclinic.services.DuenioService;

@RequestMapping("/duenios")
@Controller
public class DuenioController {
	
	private final DuenioService ds;
	
	public DuenioController(DuenioService ds) {
		// TODO Auto-generated constructor stub
		this.ds = ds;
	}
	
	@RequestMapping({"","/","/index","/index.html"})
	public String listaDuenios(Model m) {
		m.addAttribute("duenios", ds.findAll());
		
		return "duenios/index";
	}
	
	@RequestMapping("/buscar")
	public String buscarDuenios() {
		return "noImplementado";
	}
}
