package model.entity;

import lombok.*;
import model.enums.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    private String id;
    private String name;
    private String description;
    private Status status;

}
