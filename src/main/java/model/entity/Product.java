package model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private int stockQuantity;
    private String barcode;
    private String categoryId;
    private LocalDateTime dateTime;
    private enum status{active,deavtive}
}
