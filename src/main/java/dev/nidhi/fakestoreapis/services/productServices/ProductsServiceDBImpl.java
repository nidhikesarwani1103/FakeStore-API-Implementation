package dev.nidhi.fakestoreapis.services.productServices;

import dev.nidhi.fakestoreapis.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductsServiceDBImpl implements ProductService {

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(int productId) {
        return null;
    }
}
