package web.managedbeans;

import model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.ProductService;
import web.util.FacesUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexander Khodakovskyi on 03/10/14.
 */
@Component("productBean")
@Scope("session")
public class ProductBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ProductBean.class);

    @Autowired
    private ProductService productService;

    private String name;
    private String code;
    private Date startDate;
    private Date endDate;

    public List<Product> getProducts() {
        return productService.findAll();
    }

    public void addProduct() {
        Product product = new Product();

        product.setProductName(name);
        product.setProductCode(code);
        product.setStartDate(new Date());

        try {
            productService.save(product);
            FacesUtil.info("Product : " + name + " was successfully added.");
            log.info("Product : " + name + " was successfully added.");
            clear();
        } catch (Exception e) {
            FacesUtil.error("Product : " + name + " already exists!");
        }
    }

    public void clear() {
        setName(null);
        setCode(null);
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
