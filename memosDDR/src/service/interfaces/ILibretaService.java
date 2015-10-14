/**
 * 
 */
package service.interfaces;

import java.util.List;

import dao.model.Libreta;

/**
 * @author ddiaz
 *
 */
public interface ILibretaService {

	public Libreta getLibretaById(Integer id) throws Exception;
	
	public List<Libreta> getLibretas() throws Exception;
}
