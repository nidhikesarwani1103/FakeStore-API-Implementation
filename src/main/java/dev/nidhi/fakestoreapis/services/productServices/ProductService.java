package dev.nidhi.fakestoreapis.services.productServices;

import dev.nidhi.fakestoreapis.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {


    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int productId);
    Product updateProduct(int productId, Product product);

    ResponseEntity<Void> deleteProduct(int productId);
}
