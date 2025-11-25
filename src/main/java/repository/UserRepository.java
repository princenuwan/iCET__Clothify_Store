package repository;

import model.entity.User;
import java.util.List;

// DB - CRUD
public interface UserRepository{
    // save user on database
    User save(User user);

    // update user on database
    User update(User user);

    // Get all users from database
    List<User> findAll();

    // to get last userid from database
    String getLastUserId();

    // to find user by username from database
    User findByUsername(String username);

    // find user by id from database
    User findById(String id);
}
