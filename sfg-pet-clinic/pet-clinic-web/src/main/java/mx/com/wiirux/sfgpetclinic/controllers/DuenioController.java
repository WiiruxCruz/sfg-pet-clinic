package mx.com.wiirux.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/duenios")
@Controller
public class DuenioController {
	
	@RequestMapping({"","/","/index","/index.html"})
	public String listaDuenios() {
		
		return "duenios/index";
	}
}
