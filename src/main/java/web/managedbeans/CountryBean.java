package web.managedbeans;

import model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.CountryService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 03/10/14.
 */
@Component("countryBean")
@Scope("session")
public class CountryBean implements Serializable {

    private String name;
    private String code;
    private Date startDate;
    private Date endDate;

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

        countryService.save(country);
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
