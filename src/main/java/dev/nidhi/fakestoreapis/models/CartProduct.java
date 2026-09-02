package dev.nidhi.fakestoreapis.models;

import dev.nidhi.fakestoreapis.dtos.cartDTO.CartProductDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartProduct {
    private int productId;
    private int quantity;
}
