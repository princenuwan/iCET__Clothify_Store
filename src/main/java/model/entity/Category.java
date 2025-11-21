package model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    private String id;
    private String name;
    private String description;
    private enum status{active,deavtive}
}
