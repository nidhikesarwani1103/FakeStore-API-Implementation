package dev.nidhi.fakestoreapis.models.DB;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductForDB extends Basemodel{
    private String title;
    private String description;
    private float price;
    private String imageUrl;
    @ManyToOne
    private Category category;
}
