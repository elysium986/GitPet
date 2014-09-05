package dao.impl;

import dao.ProductDao;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Repository("productDao")
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {


}
