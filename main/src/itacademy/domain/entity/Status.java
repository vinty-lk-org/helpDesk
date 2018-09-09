package itacademy.domain.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private Long id;
    private String name;

    public Status(Long id) {
        this.id = id;
    }

    public Status(String name) {
        this.name = name;

    }
}
