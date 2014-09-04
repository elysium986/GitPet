package model;

import org.hibernate.annotations.Entity;

import java.util.Date;

/**
 * Created by id967145 on 21/07/14.
 */
@Entity
public class Operator {

    private Long id;

    private String operatorName;
    private String operatorCode;
    private Country country;
    private Date startDate;
    private Date endDate;
}
