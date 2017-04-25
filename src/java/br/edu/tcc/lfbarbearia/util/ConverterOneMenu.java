package br.edu.tcc.lfbarbearia.util;

import br.edu.tcc.lfbarbearia.entidades.InterfaceEntidades;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Marcos
 */

@FacesConverter(value = "classeConverter")    
//@FacesConverter(forClass = Classe.class)

public class ConverterOneMenu implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (InterfaceEntidades) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof InterfaceEntidades) {
            InterfaceEntidades entity= (InterfaceEntidades) value;
            if (entity != null && entity instanceof InterfaceEntidades && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
