package util;

import model.Country;
import model.Operator;
import model.Product;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import service.CountryService;
import service.OperatorService;
import service.ProductService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public class AppUtil {

    public static void main(String[] args) {

        CountryService countryService = SpringUtil.getCountryService();
        ProductService productService = SpringUtil.getProductService();
        OperatorService operatorService = SpringUtil.getOperatorService();

        List<Country> countries = countryService.findAll();

        Product newProduct = new Product();
        newProduct.setStartDate(new Date());
        newProduct.setProductName("GRX");
        newProduct.setProductCode("GRX");
        List<Product> product = productService.findAll();
//        product.add(newProduct);
        Set<Product> products = new HashSet<Product>();
        products.addAll(product);

        Operator newOperator = new Operator();
        newOperator.setOperatorName("MTS");
        newOperator.setOperatorCode("MTS");
        newOperator.setStartDate(new Date());
        newOperator.setCountry(countries.get(0));
        newOperator.setProducts(products);

        Operator operator = operatorService.find("Kyivstar");
//        operator.setProducts(products);
//        operatorService.update(operator);

        operatorService.save(newOperator);

    }
}
