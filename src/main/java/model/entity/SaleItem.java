package model.entity;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleItem {
    private String id;
    private String productId;
    private int quantity;
    private LocalDateTime dateTime;
}
