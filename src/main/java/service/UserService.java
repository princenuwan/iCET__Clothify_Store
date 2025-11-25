package service;

import javafx.collections.ObservableList;
import model.dto.UserDTO;

    public interface UserService {

        String generateUserId();
        UserDTO createUser(UserDTO user);
        UserDTO updateUser(UserDTO user);
        UserDTO getUserById(String id);
        UserDTO getUserByUsername(String username);
        ObservableList<UserDTO> getAllUsers();
    }

