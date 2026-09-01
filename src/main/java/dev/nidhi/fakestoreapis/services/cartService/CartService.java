package dev.nidhi.fakestoreapis.services.cartService;

import dev.nidhi.fakestoreapis.dtos.cartDTO.CartDTO;
import dev.nidhi.fakestoreapis.models.Cart;

public interface CartService {

    Cart getCartByID(int cartId);
}
