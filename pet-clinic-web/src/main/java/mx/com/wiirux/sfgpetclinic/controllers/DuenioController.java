package mx.com.wiirux.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/{duenioId}")
	public ModelAndView mostrarDuenio(@PathVariable("duenioId") Long duenioId) {
		System.out.println("Estoy aqui con:" + duenioId);
		ModelAndView mav = new ModelAndView("duenios/duenioDetalle");
		
		mav.addObject(this.ds.findById(duenioId));
		
		return mav;
	}
}
