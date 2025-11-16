package model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sale {
    private String id;
    private String userId;
    private String customerId;
    private String productId;
}
