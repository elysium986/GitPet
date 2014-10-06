package web.managedbeans;

import model.Country;
import org.richfaces.component.SortOrder;
import org.richfaces.model.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.CountryService;
import web.util.FacesUtil;

import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 03/10/14.
 */
@Component("countryBean")
@Scope("session")
public class CountryBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(CountryBean.class);

    private String name;
    private String code;
    private Date startDate;
    private Date endDate;

    private String countryFilter;
    private SortOrder countriesOrder = SortOrder.unsorted;

    @Autowired
    private CountryService countryService;


    public List<Country> getCountries() {
        return countryService.findAll();
    }

    public void addCountry() {
        Country country = new Country();

        country.setCountryName(name);
        country.setCountryCode(code);
        country.setStartDate(new Date());

        try {
            countryService.save(country);
            FacesUtil.info("Country : " + name + " was successfully added.");
            log.info("Country : " + name + " was successfully added.");
            clear();
        } catch (Exception e) {
            FacesUtil.error("Country : " + name + " already exists!");
        }
    }

    public Filter<?> getFilterCountry() {
        return new Filter<Country>() {
            public boolean accept(Country c) {
                String country = getCountryFilter();
                return country == null || country.length() == 0 || country.equals(c.getCountryName());
            }
        };
    }

    public List<SelectItem> getCountryOptions() {
        List<SelectItem> result = new ArrayList<>();
        result.add(new SelectItem("", ""));
        for (Country countryList : getCountries()) {
            result.add(new SelectItem(countryList.getCountryName()));
        }
        return result;
    }

    public void sortByName() {

        if (countriesOrder.equals(SortOrder.ascending)) {
            setCountriesOrder(SortOrder.descending);
        } else {
            setCountriesOrder(SortOrder.ascending);
        }
    }

    public void clear() {
        setName("");
        setCode("");
    }

    public String getCountryFilter() {
        return countryFilter;
    }

    public void setCountryFilter(String countryFilter) {
        this.countryFilter = countryFilter;
    }

    public SortOrder getCountriesOrder() {
        return countriesOrder;
    }

    public void setCountriesOrder(SortOrder countriesOrder) {
        this.countriesOrder = countriesOrder;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
