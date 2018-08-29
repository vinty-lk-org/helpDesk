package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class SystemUser {
    private Long id;
    private String name;
    private String famaly;
    private String email;
    private String password;
    private Branch branch;
    private Subdivision subdivision;

    public SystemUser(Long id, String name, String famaly, String email) {
        this.id = id;
        this.name = name;
        this.famaly = famaly;
        this.email = email;
    }
}
