package service.impl;

import dao.OperatorDao;
import model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OperatorService;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
@Service("operatorService")
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorDao operatorDao;

    @Override
    public void save(Operator operator) {
        operatorDao.save(operator);
    }

    @Override
    public void update(Operator operator) {
        operatorDao.update(operator);
    }

    @Override
    public void delete(Operator operator) {
        operatorDao.delete(operator);
    }

    @Override
    public Operator find(Operator operator) {
        return operatorDao.find(operator);
    }

    @Override
    public List findAll() {
        return operatorDao.findAll();
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }
}
