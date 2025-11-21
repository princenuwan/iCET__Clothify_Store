package service;

import javafx.collections.ObservableList;
import model.dto.UserDTO;

    public interface UserService {
        String generateUserId();

        UserDTO createUser(UserDTO user);
        UserDTO updateUser(UserDTO user);
        UserDTO getUserById(String id);
        ObservableList<UserDTO> getAllUsers();

        UserDTO getUserByUsername(String username);

    }

