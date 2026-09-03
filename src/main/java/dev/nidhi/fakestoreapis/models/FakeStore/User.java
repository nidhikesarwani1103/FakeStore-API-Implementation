package dev.nidhi.fakestoreapis.models.FakeStore;

import lombok.Data;

@Data
public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private Address address;
    private String phone;
}
