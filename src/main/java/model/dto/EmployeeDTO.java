package model.dto;

import lombok.*;
import model.enums.Roles;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private String id;
    private String name;
    private String contactInfo;
    private String address;
    private Roles role;
}
