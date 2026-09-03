package dev.nidhi.fakestoreapis.services.userService;

import dev.nidhi.fakestoreapis.dtos.userDTO.UserDTO;
import dev.nidhi.fakestoreapis.models.FakeStore.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User[] getAllUsers() {
        UserDTO[] users = restTemplate.getForObject(
                "https://fakestoreapi.com/users",
                UserDTO[].class
        );
        User[] userArray = new User[users.length];
        for (int i = 0; i < users.length; i++) {
            userArray[i] = users[i].toUser();
        }
        return userArray;
    }
}
