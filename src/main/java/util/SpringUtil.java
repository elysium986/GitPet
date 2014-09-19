package util;

import dao.CountryDao;
import dao.OperatorDao;
import dao.ProductDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CountryService;
import service.OperatorService;
import service.ProductService;

/**
 * Created by Alexander Khodakovskyi on 19/09/14.
 */
public class SpringUtil {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static CountryService getCountryService() {
        return (CountryService) context.getBean("countryService");
    }

    public static OperatorService getOperatorService() {
        return (OperatorService) context.getBean("operatorService");
    }

    public static ProductService getProductService() {
        return (ProductService) context.getBean("productService");
    }

    public static CountryDao getCountryDao() {
        return (CountryDao) context.getBean("countryDao");
    }

    public static OperatorDao getOperatorDao() {
        return (OperatorDao) context.getBean("operatorDao");
    }

    public static ProductDao getProductDao() {
        return (ProductDao) context.getBean("productDao");
    }
}
