package itacademy.domain.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Privilege {
    private Long id;
    private String name;

    public Privilege(Long id) {
        this.id = id;
    }

    public Privilege(String name) {
        this.name = name;
    }
}