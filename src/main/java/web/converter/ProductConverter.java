package web.converter;

import model.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ProductService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by Alexander Khodakovskyi on 15/10/14.
 */
@Component("productConverter")
public class ProductConverter implements Converter {

    @Autowired
    private ProductService productService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Product product = null;
        if (StringUtils.isNotBlank(s)) {
            product = productService.find(s);
        }
        return product;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Product product = (Product)o;
        return product != null ? product.getProductName() : "";
    }
}
