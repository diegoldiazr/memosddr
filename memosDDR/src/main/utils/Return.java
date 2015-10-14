/**
 * 
 */
package main.utils;

import java.util.List;

/**
 * @author ddiaz
 *
 */
public class Return {
	
	private int code;
	private String message;
	private int numResult;
	private List<Object> data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumResult() {
		return numResult;
	}
	public void setNumResult(int numResult) {
		this.numResult = numResult;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}

}
