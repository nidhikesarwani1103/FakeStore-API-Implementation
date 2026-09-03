package dev.nidhi.fakestoreapis.models.FakeStore;

import lombok.Data;

@Data
public class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;
}
