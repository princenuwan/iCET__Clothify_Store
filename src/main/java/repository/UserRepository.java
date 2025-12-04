package repository;

import model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

// DB - CRUD
public interface UserRepository{
    ResultSet getAll() throws SQLException;

    void addUser(User entity) throws SQLException;
    void deleteUser(String id) throws SQLException;
    void updateUser(User entity) throws  SQLException;
    ResultSet searchUser(String id) throws SQLException;
    User findByUsername(String userName) throws SQLException;
    String getLastId() throws SQLException;
}
