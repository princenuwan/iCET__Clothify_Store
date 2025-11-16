package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {
    private String id;
    private String name;
    private String description;
    private enum status{active,deavtive}
}
