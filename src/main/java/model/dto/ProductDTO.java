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
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
    private int stockQuantity;
    private String barcode;
    private String categoryId;
    private LocalDateTime dateTime;
    private Status status;
}
