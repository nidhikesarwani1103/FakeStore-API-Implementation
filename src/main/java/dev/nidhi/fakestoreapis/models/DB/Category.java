package dev.nidhi.fakestoreapis.models.DB;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends Basemodel{
    private String name;
    private String description;
    @OneToMany
    private List<ProductForDB> featuredProducts;
    @OneToMany(mappedBy = "category")
    private List<ProductForDB> AllProducts;
}
