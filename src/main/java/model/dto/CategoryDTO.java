package model.dto;

import lombok.*;
import model.enums.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {
    private String id;
    private String name;
    private String description;
    private Status status;
}
