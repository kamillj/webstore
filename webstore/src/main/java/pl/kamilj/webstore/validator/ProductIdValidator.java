package pl.kamilj.webstore.validator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kamilj.webstore.domain.Product;
import pl.kamilj.webstore.exeption.ProductNotFoundException;
import pl.kamilj.webstore.service.ProductService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductIdValidator implements ConstraintValidator<ProductId, String>{

    @Autowired
    private ProductService productService;

    public void initialize(ProductId constraintAnnotation) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product;
        try {
            product = productService.getProductById(value);

        } catch (ProductNotFoundException e) {
            return true;
        }

        if(product!= null) {
            return false;
        }

        return true;
    }

}
