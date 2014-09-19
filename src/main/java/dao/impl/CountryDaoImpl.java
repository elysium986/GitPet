package dao.impl;

import dao.CountryDao;
import model.Country;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void save(Country country) {
        getHibernateTemplate().save(country);
    }
}
