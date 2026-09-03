package dev.nidhi.fakestoreapis.dtos.userDTO;

import dev.nidhi.fakestoreapis.models.FakeStore.User;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String email;
    private String username;
    private String password;
    private NameDTO name;
    private AddressDTO address;
    private String phone;

    public static UserDTO from(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setName(NameDTO.from(user.getName()));
        userDTO.setAddress(AddressDTO.from(user.getAddress()));

        return userDTO;
    }

    public User toUser(){
        User user = new User();
        user.setId(this.getId());
        user.setEmail(this.getEmail());
        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());
        user.setPhone(this.getPhone());
        user.setName(NameDTO.toName(this.getName()));
        user.setAddress(AddressDTO.toAddress(this.getAddress()));

        return user;

    }
}
