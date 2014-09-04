package model;

import org.hibernate.annotations.Entity;

import java.util.Date;
import java.util.Set;

/**
 * Created by id967145 on 21/07/14.
 */
@Entity
public class Country {

    private Long id;
    private String countryName;
    private String countryCode;
    private Set<Operator> operators;
    private Date startDate;
    private Date endDate;

}
