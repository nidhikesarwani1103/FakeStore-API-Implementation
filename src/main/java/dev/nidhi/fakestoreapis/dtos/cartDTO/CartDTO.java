package dev.nidhi.fakestoreapis.dtos.cartDTO;

import dev.nidhi.fakestoreapis.models.Cart;
import dev.nidhi.fakestoreapis.models.CartProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CartDTO {

    private int id;
    private int userId;
    private String date;
    private List<CartProductDTO> products;

    public static CartDTO fromCart(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setUserId(cart.getUserId());
        cartDTO.setDate(cart.getDate());

        List<CartProductDTO> productDTOs = cart.getProducts()
                .stream()
                .map(cartProduct -> {
                    CartProductDTO dto = new CartProductDTO();
                    dto.setProductId(cartProduct.getProductId());
                    dto.setQuantity(cartProduct.getQuantity());
                    return dto;
                })
                .toList();

        cartDTO.setProducts(productDTOs);
        return cartDTO;
    }

    public Cart toCart() {
        Cart cart = new Cart();
        cart.setId(this.getId());
        cart.setUserId(this.getUserId());
        cart.setDate(this.getDate());

       List<CartProduct> cartProducts = this.getProducts().stream()
               .map(cartProductDTO -> {
                   CartProduct cartProduct = new CartProduct();
                   cartProduct.setProductId(cartProductDTO.getProductId());
                   cartProduct.setQuantity(cartProductDTO.getQuantity());
                     return cartProduct;
               })
               .toList();

       cart.setProducts(cartProducts);
       return cart;
    }
}
