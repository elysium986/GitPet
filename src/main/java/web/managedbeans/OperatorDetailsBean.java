package web.managedbeans;

import model.Operator;
import model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.OperatorService;
import web.util.FacesUtil;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexander Khodakovskyi on 16/10/14.
 */
@Component("operatorDetailsBean")
@Scope("request")
public class OperatorDetailsBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(OperatorDetailsBean.class);

    @Autowired
    private OperatorService operatorService;

    private Operator operator;
    private String operatorId;
    private List<Product> selectedProducts = new ArrayList<Product>();

    @PostConstruct
    private void init() {
        operatorId = FacesUtil.getRequestParam("operatorId");

        operator = operatorService.find(Long.parseLong(operatorId));
    }

    public void save() {
        try {
            if (operator != null) {
                operatorService.update(operator);
                FacesUtil.info("Operator: " + operator.getOperatorName() + " was successfully updated.");
            }
        } catch (Exception e) {
            FacesUtil.error("An error did occur!");
            log.error("An error did occur!", e.getMessage());
        }
    }

    public void removeProduct() {

    }

    public Set<Product> addProducts() {
        Set<Product> currentProducts = operator.getProducts();
        if (!selectedProducts.isEmpty()) {
            Set<Product> newProducts = new HashSet<Product>(selectedProducts);
            currentProducts.addAll(newProducts);
        }
        return currentProducts;
    }

    public Set<Product> getProducts() {
        return operator.getProducts();
    }

    public OperatorService getOperatorService() {
        return operatorService;
    }

    public void setOperatorService(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }
}
