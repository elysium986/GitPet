package dao;

import model.Operator;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public interface OperatorDao {

    void save(Operator operator);

    void delete(Operator operator);

    void update(Operator operator);

    Operator find(String name);

    List findAll();
}
