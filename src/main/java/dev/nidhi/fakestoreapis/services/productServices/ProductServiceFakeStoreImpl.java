package dev.nidhi.fakestoreapis.services.productServices;

import dev.nidhi.fakestoreapis.dtos.productDTO.FakeStoreCreateProductRequestDTO;
import dev.nidhi.fakestoreapis.dtos.productDTO.FakeStoreCreateProductResponseDTO;
import dev.nidhi.fakestoreapis.dtos.productDTO.FakeStoreProductDTO;
import dev.nidhi.fakestoreapis.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("productServiceFakeStoreImpl")
public class ProductServiceFakeStoreImpl implements ProductService {

    private final RestTemplate restTemplate;

    // Create a config class for beans that are not defined anywhere,
    // like RestTemplate
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDTO requestDTO =
                FakeStoreCreateProductRequestDTO.fromProduct(product);
        FakeStoreCreateProductResponseDTO responseDTO = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestDTO,
                FakeStoreCreateProductResponseDTO.class
        );

        assert responseDTO != null;
        return responseDTO.toProduct();
    }

//    @Override
//    public List<Product> getAllProducts() {
//        FakeStoreProductDTO[] productDTOList = restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                FakeStoreProductDTO[].class
//        );
//
//        List<Product> productList  =
//                Arrays.stream(productDTOList)
//                .map(FakeStoreProductDTO::toProduct)
//                .toList();
//        return productList;
//    }

    // To test the Exception handling, we can throw an exception here
    // and see if the global exception handler is working or not
        @Override
        public List<Product> getAllProducts() {
            throw new RuntimeException("Not Implemented Yet");
        }

    @Override
    public Product getProductById(int productId) {

//        Map<String, Integer> params = new HashMap<>();
//        params.put("id", productId);

        FakeStoreProductDTO productDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                productId  // can be a map here in case of multiple path variables, we can pass params
        );

        assert productDTO != null;
        return productDTO.toProduct();
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        FakeStoreProductDTO requestProductDTO = FakeStoreProductDTO.fromProduct(product);
        FakeStoreProductDTO responseProductDTO = restTemplate.exchange(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.PUT,
                new HttpEntity<>(requestProductDTO),
                FakeStoreProductDTO.class,
                productId
        ).getBody();
        assert responseProductDTO != null;
        return responseProductDTO.toProduct();
    }

    @Override
    public ResponseEntity<Void> deleteProduct(int productId) {
        ResponseEntity<Void> response = restTemplate.exchange(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                productId
        );
        return response;
    }
}
