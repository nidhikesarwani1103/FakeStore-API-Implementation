package dev.nidhi.fakestoreapis.dtos.productDTO;

import dev.nidhi.fakestoreapis.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreCreateProductResponseDTO {
    int id;
    private String title;
    private String description;
    private float price;
    private String image;
    private String category;


    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setImageUrl(this.image);
        product.setPrice(this.price);
        product.setCategory(this.category);
        return product;
    }
}
