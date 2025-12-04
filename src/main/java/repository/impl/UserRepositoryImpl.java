package repository.impl;

import db.DBConnection;
import model.entity.User;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public ResultSet getAll() throws SQLException {
        String SQL = "SELECT * FROM users";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pS = connection.prepareStatement(SQL);
        ResultSet rS = pS.executeQuery();

        return rS;
    }

    @Override
    public void addUser(User entity) throws SQLException {
       String SQL = "INSERT INTO users Values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

       Connection connection = DBConnection.getInstance().getConnection();
       PreparedStatement pS = connection.prepareStatement(SQL);

        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

       pS.setObject(1,entity.getId());
       pS.setObject(2,entity.getFirstName());
       pS.setObject(3,entity.getLastName());
       pS.setObject(4,entity.getUserName());
       pS.setObject(5,entity.getPassword());
       pS.setObject(6,entity.getRole());
       pS.setObject(7,entity.getStatus());
       pS.setObject(8,entity.getCreatedAt());
       pS.setObject(9, entity.getUpdatedAt());

       pS.executeUpdate();
    }

    @Override
    public void deleteUser(String id) throws SQLException {
        String SQL = "DELETE FROM users WHERE id = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pS = connection.prepareStatement(SQL);

        pS.setObject(1,id);
        pS.executeUpdate();
    }

    @Override
    public void updateUser(User entity) throws SQLException {
        String SQL = "UPDATE users SET first_name = ?, last_name = ?, user_name = ?, password = ?, role = ?, status = ? WHERE id = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pS = connection.prepareStatement(SQL);

        pS.setObject(1,entity.getFirstName());
        pS.setObject(2,entity.getLastName());
        pS.setObject(3,entity.getUserName());
        pS.setObject(4,entity.getPassword());
        pS.setObject(5,entity.getRole());
        pS.setObject(6,entity.getStatus());
        pS.setObject(7,entity.getUpdatedAt());
        pS.setObject(8,entity.getId());

        pS.executeUpdate();
    }


    @Override
    public ResultSet searchUser(String id) throws SQLException {
        String SQL = "SELECT * FROM users WHERE id = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pS = connection.prepareStatement(SQL);

        pS.setObject(1, id);
        return pS.executeQuery();
    }

    @Override
    public User findByUsername(String userName) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_name = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, userName);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new User(
                    rs.getString("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("user_name"),
                    rs.getString("password"),
                    model.enums.Roles.valueOf(rs.getString("role")),
                    model.enums.Status.valueOf(rs.getString("status")),
                    rs.getTimestamp("created_at").toLocalDateTime(),
                    rs.getTimestamp("updated_at").toLocalDateTime()
            );
        }
        return null;
    }

    @Override
    public String getLastId() throws SQLException {
        String SQL = "SELECT id FROM users ORDER BY id DESC LIMIT 1";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pS = connection.prepareStatement(SQL);
        ResultSet rS = pS.executeQuery();

        if (rS.next()){
            return rS.getString(1);
        }
        return null;
    }
}
