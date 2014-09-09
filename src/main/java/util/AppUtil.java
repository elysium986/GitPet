package util;

import model.Country;
import model.Operator;
import model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CountryService countryService = (CountryService) context.getBean("countryService");
        List<Country> countries = countryService.findAll();

        ProductService productService = (ProductService) context.getBean("productService");
        OperatorService operatorService = (OperatorService) context.getBean("operatorService");

        Product p = new Product();
        p.setStartDate(new Date());
        p.setProductName("GRX");
        p.setProductCode("GRX");
        List<Product> product = productService.findAll();
        product.add(p);
        Set<Product> products = new HashSet<Product>();
        products.addAll(product);

        Operator operator = operatorService.find("Kyivstar");
        operator.setProducts(products);

        operatorService.update(operator);

        /*Transaction tx = null;
        try {
            Configuration configuration = new Configuration();

            ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory factory = configuration.buildSessionFactory(builder.buildServiceRegistry());
            Session session = factory.openSession();

            try {
                tx = session.beginTransaction();

                session.saveOrUpdate(product);
                session.saveOrUpdate(product);
                session.saveOrUpdate(operator);
                tx.commit();

            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }*/
    }
}
