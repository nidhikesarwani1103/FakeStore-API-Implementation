package dev.nidhi.fakestoreapis.controllers;

import dev.nidhi.fakestoreapis.dtos.cartDTO.CartDTO;
import dev.nidhi.fakestoreapis.models.Cart;
import dev.nidhi.fakestoreapis.services.cartService.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/carts/{id}")
    public CartDTO getCartByID(@PathVariable("id") int cartId){
        Cart cart = cartService.getCartByID(cartId);
        return CartDTO.fromCart(cart);
    }
}
