package com.example.repository;

import com.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<User, List<Authorities>> listUser;
    private final List<Authorities> authoritiesList;


    public UserRepository() {
        listUser = new ConcurrentHashMap<>();
        authoritiesList = new ArrayList<>();
        User user1 = new User("Oleg", "12345");
        User user2 = new User("Pavel", "45678");
        User user3 = new User("Misha", "13579");
        listUser.put(user1, Arrays.asList(Authorities.values()));
        listUser.put(user2, List.of(Authorities.READ));
        listUser.put(user3, Arrays.asList(Authorities.READ, Authorities.WRITE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (Map.Entry<User, List<Authorities>> entry : listUser.entrySet()) {
            if (entry.getKey().getName().equals(user) && entry.getKey().getPassword().equals(password)) {
                return entry.getValue();
            }


        }
        return authoritiesList;
    }
}
