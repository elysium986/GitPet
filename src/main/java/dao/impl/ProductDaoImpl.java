package dao.impl;

import dao.ProductDao;
import model.Product;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Repository("productDao")
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

    @Override
    public void save(Product product) {
        getHibernateTemplate().saveOrUpdate(product);
    }

    @Override
    public void delete(Product product) {
        product.setEndDate(new Date());
        getHibernateTemplate().update(product);
    }

    @Override
    public Product find(Product product) {
        return (Product)getHibernateTemplate().get("Product", product.getId());
    }
}
