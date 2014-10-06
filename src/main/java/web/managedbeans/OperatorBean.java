package web.managedbeans;

import model.Country;
import model.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.OperatorService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 26/09/14.
 */

@Component("operatorBean")
@Scope("session")
public class OperatorBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(OperatorBean.class);

    @Autowired
    private OperatorService operatorService;

    private String operatorFilter;
    private String countryFilter;

    private String name;
    private String code;
    private Country country;
    private Date startDate;

    public List<Operator> getOperatorsList() {
        return operatorService.findAll();
    }

    public void addOperator() {
        Operator operator = new Operator();

        operator.setCountry(country);
        operator.setOperatorName(name);
        operator.setOperatorCode(code);

    }

    public String getCountryFilter() {
        return countryFilter;
    }

    public void setCountryFilter(String countryFilter) {
        this.countryFilter = countryFilter;
    }

    public String getOperatorFilter() {
        return operatorFilter;
    }

    public void setOperatorFilter(String operatorFilter) {
        this.operatorFilter = operatorFilter;
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
