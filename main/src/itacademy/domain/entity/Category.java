package itacademy.domain.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}