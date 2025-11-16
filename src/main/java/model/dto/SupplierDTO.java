package model.dto;

import lombok.*;

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
    private enum status{active,deavtive}
}
