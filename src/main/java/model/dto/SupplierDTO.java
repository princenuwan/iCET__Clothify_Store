package model.dto;

import lombok.*;
import model.enums.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierDTO {
    private String id;
    private String name;
    private String address;
    private String contactInfo;
    private Status status;
}
