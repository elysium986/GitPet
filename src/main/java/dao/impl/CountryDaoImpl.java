package dao.impl;

import dao.CountryDao;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Repository("countryDao")
public class CountryDaoImpl extends HibernateDaoSupport implements CountryDao {

}
