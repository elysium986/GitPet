package service;

import model.Operator;

import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */
public interface OperatorService {

    void save(Operator operator);

    void update(Operator operator);

    void delete(Operator operator);

    Operator find(String name);

    List findAll();
}
