package service;

import javafx.collections.ObservableList;
import model.dto.UserDTO;

import java.sql.SQLException;

public interface UserService {
        ObservableList<UserDTO> getAll();

        void addUser(UserDTO dto) throws SQLException;
        void deleteUser(String id);
        void updateUser(UserDTO dto) throws SQLException;
        UserDTO searchUser(String id);
        UserDTO getUserByUsername(String userName) throws SQLException;
        public String generateNextUserId() throws SQLException;

    }

