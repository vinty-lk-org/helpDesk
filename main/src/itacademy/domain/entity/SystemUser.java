package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class SystemUser {
    private Long id;
    private String name;
    private String famaly;
    private String email;
    private String password;
    private Branch branchId;
    private Subdivision subdivisionId;
}
