package mx.com.wiirux.sfgpetclinic.services.map;

import java.util.List;
import java.util.Set;

import mx.com.wiirux.sfgpetclinic.model.Duenio;
import mx.com.wiirux.sfgpetclinic.model.Mascota;
import mx.com.wiirux.sfgpetclinic.services.DuenioService;
import mx.com.wiirux.sfgpetclinic.services.MascotaService;
import mx.com.wiirux.sfgpetclinic.services.TipoMascotaService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class DuenioServiceMap extends AbstractMapService<Duenio, Long> implements DuenioService{

	private final TipoMascotaService tms;
	private final MascotaService ms;
	
	public DuenioServiceMap(TipoMascotaService tms, MascotaService ms) {
		// TODO Auto-generated constructor stub
		this.tms = tms;
		this.ms = ms;
	}
	
	@Override
	public Set<Duenio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Duenio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	
	@Override
	public Duenio save(Duenio object) {
		// TODO Auto-generated method stub
		
		if(object != null) {
			
			if(object.getMascotas() != null) {
				object.getMascotas().forEach( mascota -> {
					if(mascota.getTipoMascota() != null) {
						if(mascota.getTipoMascota().getId() == null) {
							mascota.setTipoMascota(tms.save(mascota.getTipoMascota()));
						}
					} else {
						throw new RuntimeException();
					}
					
					if(mascota.getId() == null) {
						Mascota mascotaSalvada = ms.save(mascota);
						mascota.setId(mascotaSalvada.getId());
					}
				});
			}
			
			return super.save(object);
		} else {
			return null;
		}
		
		
	}
	

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Duenio object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public Duenio buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		int numero = this.findAll().size();
		Set<Duenio> listado = this.findAll();
		
		return this.findAll()
				.stream()
				.filter( duenio -> duenio.getApellido().equalsIgnoreCase(apellido) )
				.findFirst()
				.orElse(null)
				;
	}

	@Override
	public List<Duenio> buscarPorApellidoLike(String apellido) {
		// TODO Auto-generated method stub
		
		//todo - impl
		return null;
	}
	
	
}
