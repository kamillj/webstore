package pl.kamilj.webstore.domain.repository;


import pl.kamilj.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByManufacturer(String manufacturer);

    Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);

    void addProduct (Product product);
}
