package web.managedbeans;

import model.Country;
import model.Operator;
import org.ajax4jsf.model.KeepAlive;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.OperatorService;

import javax.faces.bean.ManagedBean;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 26/09/14.
 */
@ManagedBean
@Component("operatorBean")
@KeepAlive
@Scope("session")
public class OperatorBean {

    private OperatorService operatorService;

    private String name;
    private String code;
    private Country country;
    private Date startDate;

    public List<Operator> getOperatorsList() {
        return operatorService.findAll();
    }

    public OperatorService getOperatorService() {
        return operatorService;
    }

    public void setOperatorService(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
