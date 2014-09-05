package service.impl;

import dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CountryService;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Service("countryService")
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
