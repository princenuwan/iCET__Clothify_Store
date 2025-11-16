package model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private enum role{admin,casheir,other};
    private enum status{active,deavtive}
}
