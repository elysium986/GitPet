package dao;

import model.Product;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public interface ProductDao {

    void save(Product product);

    void delete(Product product);

    Product find(Product product);
}
