package com.web.optiviaje.service;

 
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.optiviaje.model.EmpresaTransporte;
import com.web.optiviaje.model.NLinea;
import com.web.optiviaje.model.Paradero;
import com.web.optiviaje.model.Ruta;
import com.web.optiviaje.model.ServicioTransporte;
import com.web.optiviaje.model.UnidadTransporte;
import com.web.optiviaje.model.Usuario;
import com.web.optiviaje.model.Viaje;
import com.web.optiviaje.repository.ServicioTransporteDAO;
import com.web.optiviaje.repository.UnidadTransporteDAO;
import com.web.optiviaje.repository.UsuarioDAO;
import com.web.optiviaje.repository.ViajeDAO;
import com.web.optiviaje.repository.EmpresaTransporteDAO;
import com.web.optiviaje.repository.NLineaDAO;
import com.web.optiviaje.repository.ParaderoDAO;
import com.web.optiviaje.repository.RutaDAO;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ServicioTransporteDAO servicioTransporteDAO;
    @Autowired
    private EmpresaTransporteDAO empresaTransporteDAO;
    @Autowired
    private NLineaDAO nLineaDAO;
    @Autowired
    private ParaderoDAO paraderoDAO;
    @Autowired
    private UnidadTransporteDAO transporteDAO;
    @Autowired
    private ViajeDAO viajeDAO;
    @Autowired
    private RutaDAO rutaDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    
    
    @Override
    public ServicioTransporte save(ServicioTransporte servicioTransporte) {
        return servicioTransporteDAO.save(servicioTransporte);
    }

    @Override
    public ServicioTransporte update(ServicioTransporte servicioTransporte) {
        return servicioTransporteDAO.save(servicioTransporte);
    }

    @Override
    public void delete(Integer id) {
        servicioTransporteDAO.deleteById(id);
    }

    @Override
    public List<ServicioTransporte> findAllServicioTransporte() {
        return servicioTransporteDAO.findAll();
    }

    @Override
    public Optional<ServicioTransporte> get(Integer id) {
        return servicioTransporteDAO.findById(id);
    }

    @Override
    public EmpresaTransporte save(EmpresaTransporte empresaTransporte) {
        return empresaTransporteDAO.save(empresaTransporte);
    }

    @Override
    public EmpresaTransporte update(EmpresaTransporte empresaTransporte) {
        return empresaTransporteDAO.save(empresaTransporte);
    }

    @Override
    public void deleteet(Integer id) {
        empresaTransporteDAO.deleteById(id);
    }

    @Override
    public List<EmpresaTransporte> findAllEmpresaTransporte() {
        return empresaTransporteDAO.findAll();
    }

    @Override
    public Optional<EmpresaTransporte> getet(Integer id) {
        return empresaTransporteDAO.findById(id);
    }

    @Override
    public NLinea save(NLinea linea) {
        return nLineaDAO.save(linea);
    }

    @Override
    public NLinea update(NLinea linea) {
        return nLineaDAO.save(linea);
    }

    @Override
    public void deletetl(Integer id) {
        nLineaDAO.deleteById(id);
    }

    @Override
    public List<NLinea> findAllNLinea() {
        return nLineaDAO.findAll();
    }
    @Override
    public List<NLinea> getnl(Integer empresaTransporteId) {
        return nLineaDAO.findByEmpresaTransporteId(empresaTransporteId);
    }



    @Override
    public Paradero save(Paradero paradero) {
        return paraderoDAO.save(paradero);
    }

    @Override
    public Paradero update(Paradero paradero) {
        return paraderoDAO.save(paradero);
    }

    @Override
    public void deletep(Integer id) {
        paraderoDAO.deleteById(id);
    }

    @Override
    public List<Paradero> findAllNParadero() {
        return paraderoDAO.findAll();
    }

    @Override
    public Optional<Paradero> getp(Integer id) {
        return paraderoDAO.findById(id);
    }

    @Override
    public UnidadTransporte save(UnidadTransporte unidadTransporte) {
        return transporteDAO.save(unidadTransporte);
    }

    @Override
    public UnidadTransporte update(UnidadTransporte unidadTransporte) {
        return transporteDAO.save(unidadTransporte);
    }

    @Override
    public void deleteut(Integer id) {
        transporteDAO.deleteById(id);
    }

    @Override
    public List<UnidadTransporte> findAllNUnidadTransporte() {
        return transporteDAO.findAll();
    }

    @Override
    public Optional<UnidadTransporte> getut(Integer id) {
        return transporteDAO.findById(id);
    }

	@Override
	public Optional<NLinea> getnln(Integer id) {
		// TODO Auto-generated method stub
		return nLineaDAO.findById(id);
	}

	@Override
	public List<Paradero> getpp(Integer id) {
		// TODO Auto-generated method stubparaderoDAO.findByNLineaId(id)
		return paraderoDAO.findAllByNlinea_Id(id);
	}

	@Override
	public List<UnidadTransporte> getutt(Integer id) {
		// TODO Auto-generated method stub
		return transporteDAO.findAllByNlinea_Id(id);
	}
	
	
	//EXPERIMENTO
	 

    
	@Override
	public Optional<NLinea> findByCodigoLinea(String codigoLinea) {
		// TODO Auto-generated method stub
		return nLineaDAO.findFirstByCodigoLinea(codigoLinea);
	}
	
	@Override
	public UnidadTransporte seleccionarUnidadTransporte(String idRuta) {
	    NLinea linea = nLineaDAO.findByCodigoLinea(idRuta);
	    if (linea != null) {
	        List<UnidadTransporte> unidades = transporteDAO.findAllByNlinea_Id(linea.getId());
	        if (!unidades.isEmpty()) {
	            UnidadTransporte unidadSeleccionada = unidades.get(new Random().nextInt(unidades.size()));
	            unidadSeleccionada.setEstado(false); // Actualizar el estado a "no lleno"
	            transporteDAO.save(unidadSeleccionada);
	            return unidadSeleccionada;
	        }
	    }
	    return null; // Manejar el caso en que no se encuentren unidades de transporte
	}

	@Override
	public Ruta save(Ruta ruta) {
		// TODO Auto-generated method stub
		return rutaDAO.save(ruta);
	}

	@Override
	public Viaje save(Viaje viaje) {
		// TODO Auto-generated method stub
		return viajeDAO.save(viaje);
	}

	@Override
	public Optional<Viaje> findByUsuarioId(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public  UnidadTransporte findById(Integer idUnidadTransporte) {
	    Optional<UnidadTransporte> optionalUnidadTransporte = transporteDAO.findById(idUnidadTransporte);
	    return optionalUnidadTransporte.orElse(null);
	}
//METODOS DE USAURIO
	@Override
	public Usuario save(Usuario usuario) {
		  
		return usuarioDAO.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
 		return usuarioDAO.save(usuario);
	}

	@Override
	public void deleteu(Integer id) {
		usuarioDAO.deleteById(id);
	}

	@Override
	public List<Usuario> findAllUsuario() {
		// TODO Auto-generated method stub
		return usuarioDAO.findAll();
	}

	@Override
	public Optional<Usuario> getu(Integer id) {
		// TODO Auto-generated method stub
		return usuarioDAO.findById(id);
	}

	@Override
	public Usuario find(String correoElectronico) {
		// TODO Auto-generated method stub
		return  usuarioDAO.findByCorreoElectronico(correoElectronico);
	}

	@Override
	public List<Viaje> getU(Integer idUsuario) {
		// TODO Auto-generated method stub
		return  viajeDAO.findByusuarioId(idUsuario);
	}

	@Override
	public List<UnidadTransporte> findUnidadesByLinea(NLinea linea) {
		 
		return  transporteDAO.findAllByNlinea_Id(linea.getId());
	}

}