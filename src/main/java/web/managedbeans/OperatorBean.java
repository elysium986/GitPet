package web.managedbeans;

import model.Country;
import model.Operator;
import model.Product;
import org.richfaces.component.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.CountryService;
import service.OperatorService;
import service.ProductService;
import web.util.FacesUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
    private SortOrder countriesOrder = SortOrder.unsorted;
    private SortOrder operatorsOrder = SortOrder.unsorted;

    private String name;
    private String code;
    private Country country;
    private Date startDate;
    private List<Product> chosenProducts = new ArrayList<Product>();

    public List<Operator> getOperatorsList() {
        return operatorService.findAll();
    }

    public void addOperator() {
        Operator operator = new Operator();

        operator.setCountry(country);
        operator.setOperatorName(name);
        operator.setOperatorCode(code);
        operator.setProducts(new HashSet<Product>(chosenProducts));
        operator.setStartDate(new Date());

        try {
            operatorService.save(operator);
            FacesUtil.info("Operator : " + name  + " was successfully added.");
            log.info("Operator : " + name  + " was successfully added.");
            clear();
        } catch (Exception e) {
            FacesUtil.error("Operator : " + name  + " already exists!");
        }

    }

    public void clear() {
        setName(null);
        setCode(null);
    }

    public void sortByCountry() {
        if (countriesOrder.equals(SortOrder.ascending)) {
            setCountriesOrder(SortOrder.descending);
        } else {
            setCountriesOrder(SortOrder.ascending);
        }
    }

    public void sortByOperator() {
        if (operatorsOrder.equals(SortOrder.ascending)) {
            setOperatorsOrder(SortOrder.descending);
        } else {
            setOperatorsOrder(SortOrder.ascending);
        }
    }

    public SortOrder getOperatorsOrder() {
        return operatorsOrder;
    }

    public void setOperatorsOrder(SortOrder operatorsOrder) {
        this.operatorsOrder = operatorsOrder;
    }

    public SortOrder getCountriesOrder() {
        return countriesOrder;
    }

    public void setCountriesOrder(SortOrder countriesOrder) {
        this.countriesOrder = countriesOrder;
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

    public List<Product> getChosenProducts() {
        return chosenProducts;
    }

    public void setChosenProducts(List<Product> chosenProducts) {
        this.chosenProducts = chosenProducts;
    }

}
