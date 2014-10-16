package web.converter;

import model.Operator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.OperatorService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by Alexander Khodakovskyi on 16/10/14.
 */
@Component("operatorConverter")
public class OperatorConverter implements Converter {

    @Autowired
    private OperatorService operatorService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Operator operator = null;
        if (StringUtils.isNotBlank(s)) {
            operator = operatorService.find(s);
        }
        return operator;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Operator operator = (Operator)o;
        return operator != null ? operator.getOperatorName() : "";
    }
}
