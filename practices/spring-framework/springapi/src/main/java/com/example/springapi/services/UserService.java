package com.example.springapi.services;

import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userLists;

    public UserService() {
        userLists = new ArrayList<>(
                Arrays.asList(
                        new User(1, "SEANGLAY", 24, "seanglay@god.com"),
                        new User(2, "JOHN", 30, "john@heaven.com"),
                        new User(3, "ALICE", 28, "alice@wonder.com"),
                        new User(4, "BOB", 26, "bob@builder.com"),
                        new User(5, "CLARA", 22, "clara@dream.com"),
                        new User(6, "DAVID", 35, "david@brave.com"),
                        new User(7, "EMMA", 27, "emma@life.com"),
                        new User(8, "FRANK", 40, "frank@explorer.com"),
                        new User(9, "GRACE", 21, "grace@mercy.com"),
                        new User(10, "HENRY", 33, "henry@warrior.com"),
                        new User(11, "ISABELLA", 29, "isabella@peace.com")
                )
        );
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userLists) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
