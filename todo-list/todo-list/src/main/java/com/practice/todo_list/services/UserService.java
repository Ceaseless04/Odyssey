package com.practice.todo_list.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.todo_list.model.User;
import com.practice.todo_list.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired // This tag allows to access Repositories -> Beans
    private UserRepository userRepository;

    public User getOrCreateUser(String email, String name) {
        User user = userRepository.findByEmail(email);

        // creating a new user if user does not exist
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user);
        }

        return user;
    }
}
