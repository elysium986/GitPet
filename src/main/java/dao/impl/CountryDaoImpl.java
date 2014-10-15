package dao.impl;

import dao.CountryDao;
import model.Country;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Repository("countryDao")
public class CountryDaoImpl extends HibernateDaoSupport implements CountryDao {

    @Override
    public List findAll() {
        return getHibernateTemplate().find("from Country");
    }

    @Override
    public void save(Country country) {
        getHibernateTemplate().save(country);
    }

    @Override
    public Country find(String name) {
        return (Country)getHibernateTemplate().find("from Country where countryName = ?", name).get(0);
    }
}
