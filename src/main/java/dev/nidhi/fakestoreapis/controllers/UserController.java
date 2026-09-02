package dev.nidhi.fakestoreapis.controllers;

import dev.nidhi.fakestoreapis.dtos.userDTO.UserDTO;
import dev.nidhi.fakestoreapis.models.User;
import dev.nidhi.fakestoreapis.services.userService.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        User[] users = userService.getAllUsers();
        List<UserDTO> userDTOs = List.of(users)
                                .stream()
                                .map(user -> UserDTO.from(user))
                                .toList();

        return userDTOs;
    }
}
