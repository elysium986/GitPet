package service;

import model.Country;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public interface CountryService {

    List findAll();

    void save(Country country);

    Country find(String name);
}
