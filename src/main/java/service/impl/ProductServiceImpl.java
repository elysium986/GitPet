package service.impl;

import dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.ProductService;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
