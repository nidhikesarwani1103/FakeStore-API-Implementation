package dev.nidhi.fakestoreapis.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String title;
    private String description;
    private float price;
    private String imageUrl;
    private String category;


}
