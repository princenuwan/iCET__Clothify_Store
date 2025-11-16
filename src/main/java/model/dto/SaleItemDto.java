package model.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleItemDto {
    private String id;
    private String productId;
    private int quantity;
    private LocalDateTime dateTime;
}
