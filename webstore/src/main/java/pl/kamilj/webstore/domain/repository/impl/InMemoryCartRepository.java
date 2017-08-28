package pl.kamilj.webstore.domain.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kamilj.webstore.domain.Cart;
import pl.kamilj.webstore.domain.repository.CartRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCartRepository implements CartRepository {

    private Map<String,Cart> listOfCarts;

    public InMemoryCartRepository(){
        listOfCarts = new HashMap<String,Cart>();
    }
    @Override
    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format
                    ("Cannot create cart. Cart with this ID (%) already exists.", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(),cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format(
                    "Cannot update cart. Cart with this ID (%) does not exists", cartId));
        }
        listOfCarts.put(cartId,cart);
    }

    @Override
    public void delete(String cartId) {
        if(!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format(
                    "Cannot delete cart. Cart with this ID (%) does not exists", cartId));
        }
        listOfCarts.remove(cartId);
    }
}
