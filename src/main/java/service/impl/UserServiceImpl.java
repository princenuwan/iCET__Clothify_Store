package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.dto.UserDTO;
import model.entity.User;
import model.enums.Roles;
import model.enums.Status;
import model.mapper.UserMapper;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public ObservableList<UserDTO> getAll() {
        ObservableList<UserDTO> userObservableList = FXCollections.observableArrayList();
        try {
            ResultSet rS = userRepository.getAll();
            while (rS.next()){
                userObservableList.add(new UserDTO(
                        rS.getString("id"),
                        rS.getString("first_name"),
                        rS.getString("last_name"),
                        rS.getString("user_name"),
                        rS.getString("password"),
                        Roles.valueOf(rS.getString("role")),
                        Status.valueOf(rS.getString("status")),
                        rS.getTimestamp("created_at").toLocalDateTime(),
                        rS.getTimestamp("updated_at").toLocalDateTime()
                    )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userObservableList;
    }

    @Override
    public void addUser(UserDTO dto) throws SQLException {
        User entity = UserMapper.toEntity(dto);
        userRepository.addUser(entity);
    }

    @Override
    public void deleteUser(String id)  {
        Connection connection = null;
        try {
            userRepository.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(UserDTO dto) throws SQLException {
        User entity = UserMapper.toEntity(dto);
        userRepository.updateUser(entity);
    }

    @Override
    public UserDTO searchUser(String id) {
        try {
            ResultSet rS = userRepository.searchUser(id);
            if (!rS.next()) {
                new Alert(Alert.AlertType.ERROR, "User ID not found").show();
                return null;
            }
            rS.next();
            return new UserDTO(
                    rS.getString("id"),
                    rS.getString("first_name"),
                    rS.getString("last_name"),
                    rS.getString("user_name"),
                    rS.getString("password"),
                    Roles.valueOf(rS.getString("role")),
                    Status.valueOf(rS.getString("status")),
                    rS.getTimestamp("created_at").toLocalDateTime(),
                    rS.getTimestamp("updated_at").toLocalDateTime()
            );
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "This User id not in DataBase");
            alert.show();
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO getUserByUsername(String userName) throws SQLException {
        User user = userRepository.findByUsername(userName);
        if (user == null) return null;

        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getRole(),
                user.getStatus(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Override
    public String generateNextUserId() throws SQLException {
        String lastId = userRepository.getLastId(); // eg: USR005

        if (lastId == null || lastId.isBlank() || !lastId.startsWith("U")) {
            return "U001";
        }

        int num = Integer.parseInt(lastId.substring(3)); // remove "USR"
        num++;
        return String.format("U%04d", num);
    }
}
