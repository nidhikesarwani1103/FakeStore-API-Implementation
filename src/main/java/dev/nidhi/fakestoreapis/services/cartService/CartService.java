package dev.nidhi.fakestoreapis.services.cartService;

import dev.nidhi.fakestoreapis.dtos.cartDTO.CartDTO;
import dev.nidhi.fakestoreapis.models.Cart;

import java.util.List;

public interface CartService {

    Cart getCartByID(int cartId);
    List<Cart> getAllCarts();
}
