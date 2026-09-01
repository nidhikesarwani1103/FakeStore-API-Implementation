package dev.nidhi.fakestoreapis.services.cartService;

import dev.nidhi.fakestoreapis.dtos.cartDTO.CartDTO;
import dev.nidhi.fakestoreapis.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    private final RestTemplate restTemplate;

    public CartServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Cart getCartByID(int cartId) {
        CartDTO cartDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/{id}",
                CartDTO.class,
                cartId
        );
        assert cartDTO != null;
        return cartDTO.toCart();
    }

    @Override
    public List<Cart> getAllCarts() {

        CartDTO[] cartDTOList = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                CartDTO[].class
        );
        List<Cart> cartList = Arrays.stream(cartDTOList)
                .map(cartDTO -> cartDTO.toCart())
                .toList();

        return cartList;
    }
}
