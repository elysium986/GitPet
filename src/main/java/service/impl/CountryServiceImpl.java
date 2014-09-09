package service.impl;

import dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CountryService;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Service("countryService")
public class CountryServiceImpl implements CountryService {


    @Autowired
    CountryDao countryDao;

    @Override
    @Transactional
    public List findAll() {
        return countryDao.findAll();
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
