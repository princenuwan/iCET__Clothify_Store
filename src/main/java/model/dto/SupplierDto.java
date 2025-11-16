package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierDto {
    private String id;
    private String name;
    private String address;
    private String contactInfo;
}
