package repository;

import model.entity.User;
import java.util.List;

public interface UserRepository{
    User save(User user);
    User update(User user);
    User findById(User user);
    User findById(String id);

    List<User> FindAll();

    // Get all users
    List<User> findAll();
}
