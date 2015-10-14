/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.model.Libreta;
import service.interfaces.ILibretaService;
import utils.Return;
import utils.StandardResponse;

/**
 * @author ddiaz
 *
 */
@RestController
@RequestMapping("/data")
public class LibretaController {
	
	@Autowired
	private ILibretaService libretaService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/libreta", produces = MediaType.APPLICATION_JSON_VALUE)
	public Return getLibretaById(
			@RequestParam(value="id", required = false, defaultValue = "0") Integer id){
		Return result = new Return();
		try{
			Libreta l = libretaService.getLibretaById(id);			
			if (l!=null){
				result.setCode(StandardResponse.OK);
				result.setNumResult(1);				
				List lista = new ArrayList<>();
				lista.add(l);
				result.setData(lista);
			}else{
				result.setCode(StandardResponse.NO_CONTENT);
				result.setNumResult(0);
			}
		}catch(Exception e){
			//TODO pendiente de hacer una criba por tipos de errores
			result.setCode(StandardResponse.ERROR);
			result.setNumResult(0);
		}
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/libretas", produces = MediaType.APPLICATION_JSON_VALUE)
	public Return getLibretas(){
		Return result = new Return();
		try{
			List l = libretaService.getLibretas();
			if (l!=null){
				result.setCode(StandardResponse.OK);
				result.setNumResult(l.size());				
				result.setData(l);
			}else{
				result.setCode(StandardResponse.NO_CONTENT);
				result.setNumResult(0);
			}
		}catch(Exception e){
			//TODO pendiente de hacer una criba por tipos de errores
			result.setCode(StandardResponse.ERROR);
			result.setNumResult(0);
		}
		return result;
	}
}
