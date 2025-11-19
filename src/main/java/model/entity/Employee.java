package model.entity;

import lombok.*;
import model.enums.Status;
import model.enums.Roles;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String id;
    private String name;
    private String contactInfo;
    private String address;
    private Roles role;
    private Status status;

}
