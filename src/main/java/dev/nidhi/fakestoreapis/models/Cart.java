package dev.nidhi.fakestoreapis.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Cart {
    private int id;
    private int userId;
    private String date;
    private List<CartProduct> products;
}
