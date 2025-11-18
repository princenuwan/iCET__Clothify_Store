package model.dto;

import lombok.*;

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
    private enum status{active,deavtive}
}
