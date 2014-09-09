package service;

import model.Product;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public interface ProductService {

    void save(Product product);

    void delete(Product product);

    Product find(String name);

    List findAll();
}
