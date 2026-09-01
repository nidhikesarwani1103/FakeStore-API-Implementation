package dev.nidhi.fakestoreapis.dtos.productDTO;

import dev.nidhi.fakestoreapis.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    int id;
    private String title;
    private String description;
    private float price;
    private String image;
    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.image);
        product.setCategory(this.category);
        return product;
    }

    public static FakeStoreProductDTO fromProduct(Product product) {
        FakeStoreProductDTO productDTO = new FakeStoreProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImage(product.getImageUrl());
        productDTO.setCategory(product.getCategory());
        return productDTO;
    }
}
