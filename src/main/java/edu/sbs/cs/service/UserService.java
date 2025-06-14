package edu.sbs.cs.service;

import edu.sbs.cs.entity.User;
import edu.sbs.cs.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface UserService {

    public User createUser(User user);

//    public User updateUser(Long id, User user);
//
//    public List<User> searchUser(String username);

    public Optional<User> findUserById(Long id);

    public List<User> findUserBySE(String start, String end);

}
