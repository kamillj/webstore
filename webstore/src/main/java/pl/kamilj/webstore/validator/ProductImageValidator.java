package pl.kamilj.webstore.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.kamilj.webstore.domain.Product;

@Component
public class ProductImageValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if(product.getProductImage().isEmpty() || product.getProductImage().getSize()==0){
            errors.rejectValue("productImage","pl.kamilj.webstore.validator.productImage");
        }
        long allowedSize = 10;
        if(product.getProductImage().getSize()> allowedSize){
            errors.rejectValue("productImage", "pl.kamilj.webstore.validator.productImageSize");
        }
    }
}
