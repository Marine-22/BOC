package sk.posta.data;

import java.util.ArrayList;
import java.util.List;

import sk.posta.data.enumm.UserType;

public class ReturnData {
	private String status; // OK, NOK alebo REDIRECT
	private String redirect; // KAM sa ma spravit redirect
	private String reason; // sprava, ktora sa zobrazi v alert 
	private List<String> errors;
	private List<FieldError> fieldErrors;
	private UserType userType;
	private Object data; // data do GUI
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	public void addError(String error){
		if(this.errors == null)
			this.errors = new ArrayList<String>();
		this.errors.add(error);
	}
	public void addFieldError(String field, String error){
		if(this.fieldErrors == null)
			this.fieldErrors = new ArrayList<FieldError>();
		this.fieldErrors.add(new FieldError(field, error));
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}

class FieldError{
	private String field;
	private String error;
	
	public String getField() {
		return field;
	}



	public void setField(String field) {
		this.field = field;
	}



	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	FieldError(String field, String error){
		this.field = field;
		this.error = error;
	}
}