package pl.kamilj.webstore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamilj.webstore.domain.Product;
import pl.kamilj.webstore.domain.repository.ProductRepository;
import pl.kamilj.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        if(productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("No item in stock. Available quantity: "
                    +productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
