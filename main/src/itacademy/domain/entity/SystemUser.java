package itacademy.domain.entity;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder

public class SystemUser {
    private Long id;
    private String name;
    private String famaly;
    private String email;
    private String password;
    private Branch branch;
    private Subdivision subdivision;

    public SystemUser(Long id) {
        this.id = id;
    }

    public SystemUser(String name) {
        this.name = name;
    }
}