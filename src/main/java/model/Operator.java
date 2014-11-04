package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Alexander Khodakovskyi on 21/07/14.
 */

@Entity
@Table(name = "OPERATOR")
@SequenceGenerator(name = "SEQ_OPERATOR", sequenceName = "SEQ_OPERATOR")
public class Operator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OPERATOR")
    private Long id;
    @Column(name = "OPERATOR_NAME", unique = true, nullable = false)
    private String operatorName;
    @Column(name = "OPERATOR_CODE", unique = true, nullable = false)
    private String operatorCode;
    @ManyToOne
    @JoinColumn(name = "FK_COUNTRY")
    private Country country;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "OPERATOR_PRODUCT",
            joinColumns = @JoinColumn(name = "FK_OPERATOR"),
            inverseJoinColumns = @JoinColumn(name = "FK_PRODUCT"))
    private Set<Product> products = new HashSet<Product>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Operator other = (Operator) obj;
        return !(operatorName == null ? other.getOperatorName() != null : !operatorName.equals(other.operatorName));
    }
}
