package edu.sbs.cs.service.impl;

import edu.sbs.cs.entity.User;
import edu.sbs.cs.repository.UserRepository;
import edu.sbs.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findUserBySE(String start, String end) {
        return userRepository.findUsersByUsernameStartsWithAndUsernameEndsWith(start, end);
    }


    public User updateUser(Long id, User user) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        currentUser.setUsername(user.getUsername());
        currentUser.setPhone(user.getPhone());
        return userRepository.save(currentUser);
    }

    public List<User> searchUser(String start) {
        return userRepository.findUsersByUsernameStartingWith(start);
    }

}
