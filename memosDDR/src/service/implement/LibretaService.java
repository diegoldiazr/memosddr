/**
 * 
 */
package service.implement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import dao.model.Libreta;
import service.interfaces.ILibretaService;

/**
 * @author ddiaz
 *
 */
@Component
public class LibretaService implements ILibretaService {

	/* (non-Javadoc)
	 * @see service.interfaces.ILibretaService#getLibretaById(java.lang.Integer)
	 */
	@Override
	public Libreta getLibretaById(Integer id) throws Exception {
		if (id==1){
			return null;
		}
		Libreta l = new Libreta();
		l.setId(id);
		l.setTexto("Libreta inicial");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();		
		l.setFechaCreacion(dateFormat.format(date));
		l.setFechaModificacion(null);
		l.setBorrado(false);
		
		return l;
	}

	@Override
	public List<Libreta> getLibretas() throws Exception{
		List<Libreta> lista = new ArrayList<Libreta>();
		Libreta l = new Libreta();
		l.setId(1);
		l.setTexto("Libreta inicial");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();		
		l.setFechaCreacion(dateFormat.format(date));
		l.setFechaModificacion(null);
		l.setBorrado(false);
		
		lista.add(l);
		
		l = new Libreta();
		l.setId(2);
		l.setTexto("Libreta inicial");
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date = new Date();		
		l.setFechaCreacion(dateFormat.format(date));
		l.setFechaModificacion(null);
		l.setBorrado(false);
		
		lista.add(l);
		
		return lista;
	}

}
