package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleDTO {
    private String id;
    private String userId;
    private String customerId;
    private String productId;
}
