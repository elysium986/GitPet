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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 05/09/14.
 */

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "SEQ_PRODUCT",sequenceName = "SEQ_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    private Long id;
    @Column(name = "PRODUCT_NAME", unique = true, nullable = false)
    private String productName;
    @Column(name = "PRODUCT_CODE", unique = true, nullable = false)
    private String productCode;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy ="products")
    /*@JoinTable(
            name = "OPERATOR_PRODUCT",
            joinColumns = @JoinColumn(name = "FK_PRODUCT"),
            inverseJoinColumns = @JoinColumn(name = "FK_OPERATOR")) */
    private List<Operator> operators = new ArrayList<Operator>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }
}
