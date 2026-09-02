package dev.nidhi.fakestoreapis.services.userService;

import dev.nidhi.fakestoreapis.dtos.userDTO.UserDTO;
import dev.nidhi.fakestoreapis.models.User;

import java.util.List;

public interface UserService {
    User[] getAllUsers();
}
