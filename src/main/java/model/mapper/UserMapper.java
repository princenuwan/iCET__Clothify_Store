package model.mapper;

import model.dto.UserDTO;
import model.entity.User;

public class UserMapper {
    //DTO->Entity
    public static User toEntity(UserDTO dto){
        return new User(
            dto.getId(),
            dto.getFirstName(),
            dto.getLastName(),
            dto.getUserName(),
            dto.getPassword(),
            dto.getRole(),
            dto.getStatus(),
            dto.getCreatedAt(),
            dto.getUpdatedAt()
        );
    }

    //Entity ->DTO
    public static UserDTO toDTO(User entity){
        return new UserDTO(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName(),
            entity.getUserName(),
            entity.getPassword(),
            entity.getRole(),
            entity.getStatus(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
