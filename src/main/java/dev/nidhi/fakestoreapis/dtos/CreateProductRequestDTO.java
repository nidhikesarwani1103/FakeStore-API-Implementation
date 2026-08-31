package dev.nidhi.fakestoreapis.dtos;

import dev.nidhi.fakestoreapis.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private float price;
    private String imageUrl;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setImageUrl(this.imageUrl);
        product.setPrice(this.price);
        product.setCategory(this.category);
        return product;
    }
}
