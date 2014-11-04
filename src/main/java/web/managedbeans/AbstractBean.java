package web.managedbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 16/10/14.
 */
@Component("abstractBean")
@Scope("session")
public abstract class AbstractBean implements Serializable {

    public String clear(final String parentComponentId) {
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent fc = view.findComponent(parentComponentId);
        if (null != fc) {
            List<UIComponent> components = fc.getChildren();
            for (UIComponent component : components) {
                if (component instanceof UIInput) {
                    UIInput input = (UIInput) component;
                    input.resetValue();
                    input.setValue(null);
                }
            }
        }
        return null;
    }
}
