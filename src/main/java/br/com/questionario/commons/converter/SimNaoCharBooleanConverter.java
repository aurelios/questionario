package br.com.questionario.commons.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("SimNaoCharBooleanConverter")
public class SimNaoCharBooleanConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		Boolean boolean1 = Boolean.valueOf(arg2);

		if (boolean1) {
			return "S";
		} else {
			return "N";
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		String retorno = Boolean.FALSE.toString();

		if (arg2 != null && "S".equalsIgnoreCase(String.valueOf(arg2))) {
			retorno = Boolean.TRUE.toString();
		}
		return retorno;
	}
}