package pl.kamilj.webstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import pl.kamilj.webstore.validator.ProductId;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@AllArgsConstructor
@Data
@XmlRootElement
public class Product {

    @Pattern(regexp = "P[0-9]+", message = "{Pattern.Product.productId.validation}")
    @ProductId
    private String productId;
    @Size(min=3, max=50, message = "{Size.Product.name.validation}")
    private String name;
    @Min(value = 0, message = "{Min.Product.unitPrice.validation}")
    @Digits(integer = 8, fraction = 2, message = "{Digits.Product.unitPrice.validation}" )
    @NotNull(message = "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    @NotEmpty(message = "{NotEmpty.Product.description.validation}")
    private String description;
    @NotEmpty(message = "{NotEmpty.Product.manufacturer.validation}")
    private String manufacturer;
    @Pattern(regexp = "Fruits|Vegetables", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "{Pattern.Product.category.validation}")
    private String category;
    @Min(value = 0, message = "{Min.Product.unitsInStock.validation}")
    private long unitsInStock;
    @Min(value = 0, message = "{Min.Product.unitsInOrder.validation}")
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;
    @JsonIgnore
    private MultipartFile productImage;
    @JsonIgnore
    private MultipartFile productInfo;

    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }

    @XmlTransient
    public MultipartFile getProductInfo() {
        return productInfo;
    }
}