package dev.nidhi.fakestoreapis.controllers;

import dev.nidhi.fakestoreapis.dtos.CreateProductRequestDTO;
import dev.nidhi.fakestoreapis.dtos.CreateProductResponseDTO;
import dev.nidhi.fakestoreapis.dtos.ErrorResponseDTO;
import dev.nidhi.fakestoreapis.dtos.FakeStoreProductDTO;
import dev.nidhi.fakestoreapis.models.Product;
import dev.nidhi.fakestoreapis.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("productServiceFakeStoreImpl") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<FakeStoreProductDTO> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        List<FakeStoreProductDTO> productDTOList =
                productList.stream()
                .map(FakeStoreProductDTO::fromProduct)
                .toList();
        return productDTOList;
    }

    @PostMapping("/products")
    public CreateProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
      // return "Product created with title: "+createProductRequestDTO.getTitle();
        Product product = productService.createProduct(createProductRequestDTO.toProduct());
        return CreateProductResponseDTO.fromProduct(product);
    }

    @GetMapping("/products/{id}")
    public FakeStoreProductDTO getProduct(@PathVariable("id") int productId){
        Product product = productService.getProductById(productId);
        return FakeStoreProductDTO.fromProduct(product);
    }

    @PutMapping("/products/{id}")
    public FakeStoreProductDTO updateProduct(@PathVariable("id") int productId,
                                             @RequestBody FakeStoreProductDTO productDTO){
        Product product = productService.updateProduct(productId, productDTO.toProduct());
        return FakeStoreProductDTO.fromProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") int productId){
        ResponseEntity<Void> response = productService.deleteProduct(productId);

        if(response.getStatusCode().is2xxSuccessful()){
            return "Product deleted successfully";
        }
        else{
            return "Failed to delete product";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "Error: " + e.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDTO handleRuntimeException(RuntimeException e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(e.getMessage());
        errorResponseDTO.setStatus("500");
        return errorResponseDTO;
    }

}
