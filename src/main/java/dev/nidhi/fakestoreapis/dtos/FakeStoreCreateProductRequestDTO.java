package dev.nidhi.fakestoreapis.dtos;

import dev.nidhi.fakestoreapis.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreCreateProductRequestDTO {
    int id;
    private String title;
    private String description;
    private float price;
    private String image;
    private String category;

    public static FakeStoreCreateProductRequestDTO fromProduct(Product product) {
        FakeStoreCreateProductRequestDTO requestDTO = new FakeStoreCreateProductRequestDTO();
        requestDTO.setId(product.getId());
        requestDTO.setTitle(product.getTitle());
        requestDTO.setDescription(product.getDescription());
        requestDTO.setPrice(product.getPrice());
        requestDTO.setImage(product.getImageUrl());
        requestDTO.setCategory(product.getCategory());

        return requestDTO;
    }

//    public Product toProduct(){
//        Product product = new Product();
//        product.setTitle(this.title);
//        product.setDescription(this.description);
//        product.setImageUrl(this.imageUrl);
//        product.setPrice(this.price);
//        product.setCategory(this.category);
//        return product;
//    }
}
