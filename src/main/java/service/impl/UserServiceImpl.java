package service.impl;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import model.dto.UserDTO;
import model.entity.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new UserRepositoryImpl();
    private int lastUserNumber = 0;

    private String generateUserId(){
        lastUserNumber++;
        return String.format("U%04d", lastUserNumber);
    }

    private User dtoToEntity(UserDTO dto){
        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    private UserDTO entityToDTO(User entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        dto.setCreatedAt(dto.getCreatedAt());
        dto.setUpdatedAt(dto.getUpdatedAt());
        return dto;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        user.setId(generateUserId());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        User saved = userRepository.save(dtoToEntity(user));
        return entityToDTO(saved);
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        user.setUpdatedAt(LocalDateTime.now());
        User updated = userRepository.update(dtoToEntity(user));
        return entityToDTO(updated);
    }

    @Override
    public UserDTO getUserById(String id) {
        User entity = userRepository.findById(id);
        return entity != null ? entityToDTO(entity) : null;
    }

    @Override
    public ObservableList<UserDTO> getAllUsers() {
        List<UserDTO> dtoList =  userRepository.FindAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
        return FXCollections.observableArrayList(dtoList);
    }
}
