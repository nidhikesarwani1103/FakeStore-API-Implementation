package dev.nidhi.fakestoreapis.dtos;

import dev.nidhi.fakestoreapis.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductResponseDTO {
    private int id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static CreateProductResponseDTO fromProduct(Product product){
        CreateProductResponseDTO responseDTO = new CreateProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());

        return responseDTO;
    }

}
