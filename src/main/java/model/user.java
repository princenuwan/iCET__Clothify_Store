package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class user {
    private String Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private enum role{admin,casheir,user};
}
