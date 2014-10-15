package web.converter;

import model.Country;
import model.Product;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.CountryService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by id967145 on 15/10/14.
 */
@Component("countryConverter")
public class CountryConverter implements Converter {

    @Autowired
    private CountryService countryService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Country country = null;
        if (NumberUtils.isNumber(s)) {
            country = countryService.find(s);
        }
        return country;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Country country = (Country) o;
        return country != null ? country.getCountryName() : "";
    }
}
