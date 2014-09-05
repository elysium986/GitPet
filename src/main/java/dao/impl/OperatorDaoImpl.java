package dao.impl;

import dao.OperatorDao;
import model.Operator;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
@Repository("operatorDao")
public class OperatorDaoImpl extends HibernateDaoSupport implements OperatorDao {

    @Override
    public void save(Operator operator) {
        getHibernateTemplate().save(operator);
    }

    @Override
    public void delete(Operator operator) {
        operator.setEndDate(new Date());
        getHibernateTemplate().update(operator);
    }

    @Override
    public void update(Operator operator) {
        getHibernateTemplate().saveOrUpdate(operator);
    }

    @Override
    public Operator find(Operator operator) {
        return (Operator)getHibernateTemplate().get("Operator", operator.getId());
    }

    @Override
    public List findAll() {
        return getHibernateTemplate().find("from Operator");
    }
}
