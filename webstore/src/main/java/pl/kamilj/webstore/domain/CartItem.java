package pl.kamilj.webstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class CartItem {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(Product product) {
    }

    public void updateTotalPrice() {
        totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }
}
