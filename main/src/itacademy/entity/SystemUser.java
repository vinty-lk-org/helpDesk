package itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class SystemUser {
    private Long id;
    private String name;
    private String famaly;
    private String email;
    private Privilege privilegeId;
    private String password;
    private Branch branchId;
    private Subdivision subdivisionId;
}
