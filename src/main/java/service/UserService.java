package service;

import javafx.collections.ObservableList;
import model.dto.UserDTO;

    public interface UserService {
        UserDTO createUser(UserDTO user);
        UserDTO updateUser(UserDTO user);
        UserDTO getUserById(String id);
        ObservableList<UserDTO> getAllUsers();
    }

