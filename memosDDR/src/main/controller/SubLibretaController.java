/**
 * 
 */
package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.dao.model.SubLibreta;
import main.service.interfaces.ISubLibretaService;
import main.utils.Return;
import main.utils.StandardResponse;

/**
 * @author ddiaz
 *
 */
@RestController
@RequestMapping("/data")
public class SubLibretaController {
	
	@Autowired
	private ISubLibretaService subLibretaService;

	private Logger log = Logger.getLogger(SubLibretaController.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/subLibreta", produces = MediaType.APPLICATION_JSON_VALUE)
	public Return getLibretaById(
			@RequestParam(value="id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value="idLibreta", required = false, defaultValue = "0") Integer idLibreta){
		Return result = new Return();
		try{
			if (id != 0){
				SubLibreta l = subLibretaService.getSubLibretaById(id);					
				if (l!=null){											
					List lista = new ArrayList<>();
					lista.add(l);
					result.setData(lista);
				}else{
					result.setCode(StandardResponse.SIN_CONTENIDO);
					result.setMessage(StandardResponse.MESSAGE_SIN_CONTENIDO);
					result.setNumResult(0);
				}
			}else{
				List l = subLibretaService.getByQuery(idLibreta);				
				if (l!=null){				
					result.setNumResult(l.size());				
					result.setData(l);
				}else{
					result.setCode(StandardResponse.SIN_CONTENIDO);
					result.setMessage(StandardResponse.MESSAGE_SIN_CONTENIDO);
					result.setNumResult(0);
				}
			}
		}catch(Exception e){
			result = StandardResponse.getResponseInExceptionInt(e, log);
		}
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/subLibretas", produces = MediaType.APPLICATION_JSON_VALUE)
	public Return getLibretas(){
		Return result = new Return();
		try{
			List l = subLibretaService.getSubLibretas();
			if (l!=null){				
				result.setNumResult(l.size());				
				result.setData(l);
			}else{
				result.setCode(StandardResponse.SIN_CONTENIDO);
				result.setMessage(StandardResponse.MESSAGE_SIN_CONTENIDO);
				result.setNumResult(0);
			}
		}catch(Exception e){
			result = StandardResponse.getResponseInExceptionInt(e, log);
		}
		return result;
	}
}
