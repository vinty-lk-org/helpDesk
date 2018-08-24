package itacademy.domainModel.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Branch {
    private Long id;
    private String name;

    public Branch(String name) {
        this.name = name;
    }
}
