package model.dto;

import lombok.*;
import model.enums.Roles;
import model.enums.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String id;
    private String name;
    private String contactInfo;
    private LocalDateTime dateTime;
    private Status status;
}
