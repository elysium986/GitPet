package service.impl;

import dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.CountryService;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public class CountryServiceImpl implements CountryService {


    @Autowired
    CountryDao countryDao;

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
