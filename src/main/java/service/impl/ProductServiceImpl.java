package service.impl;

import dao.ProductDao;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProductService;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    @Transactional
    public Product find(String name) {
        return productDao.find(name);
    }

    @Override
    public List findAll() {
        return productDao.findAll();
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
