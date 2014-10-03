package dao;

import model.Country;
import model.Operator;
import model.Product;
import org.junit.Test;
import util.SpringUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexander Khodakovskyi on 19/09/14.
 */

public class OperatorDaoTest {

    @Test
    public void save() {
        OperatorDao operatorDao = SpringUtil.getOperatorDao();
        CountryDao countryDao = SpringUtil.getCountryDao();

        Country country = new Country();
        country.setCountryName("Test Country");
        country.setCountryCode("Test Country");
        country.setStartDate(new Date());
        countryDao.save(country);

        Product product = new Product();
        product.setProductCode("Test Product");
        product.setProductName("Test Product");
        product.setStartDate(new Date());

        Set<Product> products = new HashSet<Product>();
        products.add(product);

        Operator operator = new Operator();
        operator.setOperatorName("Test Operator");
        operator.setOperatorCode("Test Operator");
        operator.setStartDate(new Date());
        operator.setCountry(country);
        operator.setProducts(products);

        operatorDao.save(operator);
    }
}
