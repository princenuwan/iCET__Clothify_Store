package model.entity;

import lombok.*;
import model.enums.Roles;
import model.enums.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Roles role;
    private Status status;
}
