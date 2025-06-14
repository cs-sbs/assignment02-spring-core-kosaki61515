package edu.sbs.cs.repository;

import edu.sbs.cs.entity.Book;
import edu.sbs.cs.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String email);
//    select * from users where email = '?'

    List<User> findUsersByEmailStartsWith(String emailStartsWith);

    List<User> findUsersByUsernameStartingWith(String usernameStartsWith);

    List<User> findUsersByUsernameStartsWithAndUsernameEndsWith(String usernameStartsWith, String usernameEndsWith);
//    select * from users where username like '%?' and username like '?%';

    List<User> findUsersByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    boolean findUsersByCreatedAtIsAfter(LocalDateTime to);
















    //    Optional<User> findUserByUsername(String username);
//
//    Optional<User> findUserByPhone(String phone);
//
//    List<User> findByCreatedAtAfter(LocalDateTime createdAtAfter);
//
//    List<User> findUserByUsernameStartsWith(String username);
//
//    boolean existsUserByUsername(String username);
}
