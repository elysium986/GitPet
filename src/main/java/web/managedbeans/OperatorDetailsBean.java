package web.managedbeans;

import model.Operator;
import model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.OperatorService;
import service.ProductService;
import web.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.event.FacesEvent;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Alexander Khodakovskyi on 16/10/14.
 */
@Component("operatorDetailsBean")
@Scope("view")
public class OperatorDetailsBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(OperatorDetailsBean.class);

    @Autowired
    private OperatorService operatorService;
    @Autowired
    private ProductService productService;

    private Operator operator;
    private String operatorId;
    private boolean checked;
    private boolean checkedAll;
    private Set<Product> selectedProducts = new HashSet<Product>();

    @PostConstruct
    private void init() {
        operatorId = FacesUtil.getRequestParam("operatorId");

        operator = operatorService.find(Long.parseLong(operatorId));
    }

    public void save() {
        try {
            if (operator != null) {
                operator.setUpdated(new Date());
                operatorService.update(operator);
                FacesUtil.info("Operator: " + operator.getOperatorName() + " was successfully updated.");
                selectedProducts.clear();
            }
        } catch (Exception e) {
            FacesUtil.error("An error did occur!");
            log.error("An error did occur!", e.getMessage());
        }
    }

    public Operator removeProduct() {
        return null;
    }

    public Operator addProducts() {
        if (!selectedProducts.isEmpty()) {
            Set<Product> currentProducts = operator.getProducts();
            Set<Product> newProducts = new HashSet<Product>(selectedProducts);
            currentProducts.addAll(newProducts);
            operator.setProducts(currentProducts);

            return operator;
        }
        FacesUtil.warn("Please select a product!");
        return null;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(operator.getProducts());
    }

    public List<Product> getAvailable() {
        List<Product> all = productService.findAll();
        List<Product> available = new ArrayList<Product>();
        for (Product p : all) {
            if (newProduct(p)) {
                available.add(p);
            }
        }
        return available;
    }

    public boolean display() {
        return !getAvailable().isEmpty();
    }

    public void addSelected(FacesEvent event) {
        String productName = FacesUtil.getRequestParam("selectedObject");
        Product product = productService.find(productName);
        if (isChecked() && product != null) {
            selectedProducts.add(product);
        }
    }

    private boolean newProduct(Product product) {
        for (Product p : getProducts()) {
            if (p.getProductCode().equals(product.getProductCode())) {
                return false;
            }
        }
        return true;
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

    public Set<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(Set<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isCheckedAll() {
        return checkedAll;
    }

    public void setCheckedAll(boolean checkedAll) {
        this.checkedAll = checkedAll;
    }
}
