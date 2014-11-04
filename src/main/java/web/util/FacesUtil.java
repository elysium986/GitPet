package web.util;

import org.apache.commons.lang3.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Alexander Khodakovskyi on 03/10/14.
 */
public class FacesUtil {

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    private static boolean isMessageAlreadyAdded(String clientId, FacesMessage message) {
        if (!getFacesContext().getMessages(clientId).hasNext()) return false;

        String summary = getString(message.getSummary(), "");
        String detail = getString(message.getDetail(), "");

        for (Iterator<FacesMessage> iterator =
                     getFacesContext().getMessages(clientId); iterator.hasNext();) {
            FacesMessage next = iterator.next();
            if (summary.equals(getString(next.getSummary(), ""))
                    && detail.equals(getString(next.getDetail(), ""))) return true;
        }

        return false;
    }

    private static String getString(String text, String resultIfEmpty) {
        return !StringUtils.isEmpty(text) ? text : resultIfEmpty;
    }

    private static void addMessage(String clientId, FacesMessage message) {
        if (!isMessageAlreadyAdded(clientId, message))
            getFacesContext().addMessage(clientId, message);
    }

    public static void fatal(String summary) {
        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, getI18NMessage(summary), null));
    }

    public static void error(String summary) {
        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, getI18NMessage(summary), null));
    }

    public static void error(UIComponent component, String summary) {
        addMessage(component.getClientId(getFacesContext()),
                new FacesMessage(FacesMessage.SEVERITY_ERROR, getI18NMessage(summary), null));
    }

    public static void error(String summary, Object... parameters) {
        addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, getI18NMessage(summary, parameters), null));
    }

    public static void warn(String summary) {
        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, getI18NMessage(summary), null));
    }

    public static void info(String summary) {
        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, getI18NMessage(summary), null));
    }

    public static void info(String summary, String... parameters) {
        addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, getI18NMessage(summary, parameters), null));
    }

    public static String getI18NMessage(String key) {

        String message = key;
        FacesContext ctx = getFacesContext();
        Locale locale = ctx.getViewRoot().getLocale();
        String bundleName = ctx.getApplication().getMessageBundle();

        if (bundleName != null) {
            ResourceBundle bundle = ResourceBundle
                    .getBundle(bundleName, locale, Thread.currentThread().getContextClassLoader());
            if (bundle != null) {
                if (bundle.containsKey(key)) {
                    message = bundle.getString(key);
                }
            }
        }
        return message;
    }

    public static String getI18NMessage(String key, String... parameters) {
        String message = getI18NMessage(key);
        MessageFormat form = new MessageFormat(message);
        return form.format(parameters);

    }

    public static String getI18NMessage(String key, Object... parameters) {
        String message = getI18NMessage(key);
        MessageFormat form = new MessageFormat(message);
        return form.format(parameters);

    }

    public static String getRequestParam(String paramName) {
        return (String) getExternalContext().getRequestParameterMap().get(paramName);
    }

    public static ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }
}
