package com.quachhengtony.todomanager.service;

import com.quachhengtony.todomanager.model.User;
import com.quachhengtony.todomanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
