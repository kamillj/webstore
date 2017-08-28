package pl.kamilj.webstore.service;


import pl.kamilj.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Product getProductById(String productId);

    List<Product> getProductsByManufacturer(String manufacturer);

    Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);

    void addProduct(Product product);
}
