package service;

import model.Product;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public interface ProductService {

    void save(Product product);

    void delete(Product product);

    Product find(Product product);
}
