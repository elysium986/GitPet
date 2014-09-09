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

        Product product = new Product();
        product.setProductCode("VOICE");
        product.setProductName("Voice");
        product.setStartDate(new Date());

        Set<Product> products = new HashSet<Product>();
        products.add(product);

        Operator operator = operatorService.find("Kyivstar");

        productService.save(product);
        operatorService.save(operator);

        /*Transaction tx = null;
        try {
            Configuration configuration = new Configuration();

            ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory factory = configuration.buildSessionFactory(builder.buildServiceRegistry());
            Session session = factory.openSession();

            try {
                tx = session.beginTransaction();

                session.saveOrUpdate(product);
                session.saveOrUpdate(product1);
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
