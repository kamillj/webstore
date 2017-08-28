package pl.kamilj.webstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
public class Cart {
    private String cartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart(String cartId) {
        cartItems = new HashMap<String, CartItem>();
        grandTotal = new BigDecimal(0);
    }

    public void addCartItem(CartItem item) {
        String productId = item.getProduct().getProductId();
        if (cartItems.containsKey(productId)) {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, item);
        }
        updateGrandTotal();
    }
    public void removeCartItem(CartItem item){
        String productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }
    public void updateGrandTotal(){
        grandTotal = new BigDecimal(0);
        for(CartItem item:cartItems.values()){
            grandTotal = grandTotal.add(item.getTotalPrice());
        }
    }
}
