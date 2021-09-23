package mx.com.wiirux.sfgpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import mx.com.wiirux.sfgpetclinic.model.TipoMascota;
import mx.com.wiirux.sfgpetclinic.services.TipoMascotaService;

@Component
public class TipoMascotaFormatter implements Formatter<TipoMascota>{
	
	private final TipoMascotaService tipoMascotaService;
	
	public TipoMascotaFormatter(TipoMascotaService tipoMascotaService) {
		// TODO Auto-generated constructor stub
		this.tipoMascotaService = tipoMascotaService;
	}
	
	@Override
	public String print(TipoMascota tipoMascota, Locale locale) {
		return tipoMascota.getTipo();
	}

	@Override
	public TipoMascota parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		Collection<TipoMascota> buscarTipoMascota = this.tipoMascotaService.findAll();
		
		for(TipoMascota tipo : buscarTipoMascota) {
			if(tipo.getTipo().equals(text)) {
				return tipo;
			}
		}
		throw new ParseException("Tipo no encontrado: " + text, 0);
	}
}
