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

    public Long getId() {
        return id;
    }

    public Status setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Status setName(String name) {
        this.name = name;
        return this;
    }
}
